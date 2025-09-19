package com.dev.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.app.model.Product;

@Component
public class ProductService {

	@Autowired
	Product prod;
	
	public void printValues() {
		System.out.println("Pruduct-->"+prod);
	}
}
