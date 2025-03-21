package com.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	int pid;
	String productName;
	String productDesc;
	double price;

	int quantity;

	String category;

	boolean inStock;

	String color;
}
