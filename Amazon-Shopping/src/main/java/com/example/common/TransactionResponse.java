package com.example.common;

import com.example.entity.Order;

import lombok.Data;

@Data

public class TransactionResponse {

	private Order order;
	private double amount;
	private String tansactionId;
}
