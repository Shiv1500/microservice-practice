package com.example.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ORDER_TB")
@Component
public class Order {
	@Id
	@GeneratedValue
	private int orderId;
	private String name;
	private int qty;
	private double amount;
	
}
