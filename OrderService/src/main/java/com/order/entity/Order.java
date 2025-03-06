package com.order.entity;

import java.time.LocalDate;

import com.order.enums.OrderStatus;
import com.order.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "OrderId")
	int orderId;
	
	String customerId;
	
	String customerName;
	
	String shippingAddress;
	
	LocalDate orderDate;
	
	LocalDate estimateDeliveryDate;
	
	OrderStatus orderStatus; 
	
	PaymentStatus paymentStatus;
	
	String paymentId;
	
	int productId;
	String productName;
	double price;
	String color;
	String category;
	int quantity;
}
