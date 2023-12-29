package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.common.TransactionRequest;
import com.example.common.TransactionResponse;
import com.example.entity.Order;
import com.example.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private OrderService orderService;

	@GetMapping("/{price}")
	public String invokePaymentService(@PathVariable int price) {
		System.out.println("calling payment service");
		String url = "http://PAYMENT-SERVICE/payment/"+price;
		ResponseEntity<String> postForEntity = restTemplate.postForEntity(url, "", String.class);
		String body = postForEntity.getBody();
		System.out.println("call payment service done ");

		return body;
	}

	@GetMapping("/test")
	public String test() {
		return "working....";
	}

	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
		System.out.println("TransactionRequest--->"+request);
		return orderService.saveOrder(request);
	}
	
	@GetMapping("getOrder/{orderId}")
	public Order getOrderDetails(@PathVariable String orderId) {
		return orderService.getOrderDetails(Integer.parseInt(orderId));
	}

}
