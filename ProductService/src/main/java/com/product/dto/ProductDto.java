package com.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
	int pid;

	String productName;

	String productDesc;

	double price;

	int quantity;

	String category;

	boolean inStock;

	String color;

}
