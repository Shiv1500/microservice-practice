package com.example.common;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Payment {
	private int paymentId;
	private String paymentStatus;
	private String transectionId;
	private int orderid;
	private double amount;
	
}
