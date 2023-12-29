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
@Entity
@Data
@Table(name = "PAYMENT_TB")
@Component
public class Payment {
	@Id
	@GeneratedValue
	private int paymentId;
	private String paymentStatus;
	private String transectionId;
	private double amount;
	
	
}
