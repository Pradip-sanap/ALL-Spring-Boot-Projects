package com.cybage.entity;

//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Product {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;
	String pname;
	double price;
	
}
