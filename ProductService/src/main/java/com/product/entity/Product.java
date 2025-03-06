package com.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Product_Id")
	int pid;
	
	@Column(name = "Product_name")
	String productName;
	
	@Column(name = "Product_Desc")
	String productDesc;
	
	@Column(name = "Price")
	double price;
	
	@Column(name = "Quantity")
	int quantity;
	
	@Column(name = "Category")
	String category;
	
	@Column(name = "InStock")
	boolean inStock;
	
	@Column(name = "Color")
	String color;
}
