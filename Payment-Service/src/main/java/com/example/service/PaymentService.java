package com.example.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Payment;
import com.example.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;


	public Payment doPayment(Payment payment) {
		payment.setTransectionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
}
