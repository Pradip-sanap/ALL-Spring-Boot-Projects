package com.order.dto;

import java.time.LocalDate;

import com.order.enums.OrderStatus;
import com.order.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	int orderId;
	
	int productId;
	 
	String customerId;
	
	String customerName;
	
	String shippingAddress;
	
	LocalDate orderDate;
	
	LocalDate estimateDeliveryDate;
	
	OrderStatus orderStatus;
	
	PaymentStatus paymentStatus;
	
	String paymentId;
	

	int quantity;
}
