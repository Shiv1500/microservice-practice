package com.example.common;

import org.springframework.stereotype.Component;

import com.example.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TransactionRequest {
	
	private Order order;
	private Payment payment;

}
