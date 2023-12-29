package com.example.service;

import java.util.Objects;
import java.util.Optional;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.common.Payment;
import com.example.common.TransactionRequest;
import com.example.common.TransactionResponse;
import com.example.entity.Order;
import com.example.exception.BadRequestException;
import com.example.exception.InternalServerException;
import com.example.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;


	public TransactionResponse saveOrder(TransactionRequest request) {
		TransactionResponse transactionResponse = new TransactionResponse();
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderid(order.getOrderId());
		payment.setAmount(order.getAmount());
		payment.setTransectionId(MDC.get("transactionId"));
		// calling payment service 
		try {
		Payment paymentResponse = restTemplate.postForObject("http://localhost:9292/payment/doPayment", payment, Payment.class);
		
		
		if(Objects.nonNull(paymentResponse)) {
			orderRepository.save(order);
			transactionResponse.setAmount(paymentResponse.getAmount());
			transactionResponse.setTansactionId(paymentResponse.getTransectionId());
			transactionResponse.setOrder(order);
			log.info("Payment Service Response:{}", paymentResponse);
			return transactionResponse;
		}else {
			
			throw new InternalServerException(HttpStatus.INTERNAL_SERVER_ERROR,"Exception call Payment Service");
		}
		}catch (Exception e) {
			log.error("Error Occured while Calling Paymnet Service : {} ", e.getMessage());
			throw new InternalServerException(HttpStatus.INTERNAL_SERVER_ERROR,"Exception call Payment Service");
		}
		
	}


	public Order getOrderDetails(int orderId) {
		log.info("get Order by orderId :{} ",orderId);
		Optional<Order> optional = orderRepository.findById(orderId);
		if(optional.isPresent()) {
			return optional.get();	
		}else {
			log.info("data not get by orderId :{} ",orderId);
			throw new BadRequestException(HttpStatus.BAD_REQUEST,"");
		}
		
	}
}
