package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Payment;
import com.example.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/{price}")
	public String payment(@PathVariable  int price) {
		System.out.println(" payment service executing ");
		return "payment done Rs "+price;
	}
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment) {
		System.out.println("paymentService -->"+payment);
		return paymentService.doPayment(payment);
	}

}
