package com.cybage.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Car_details")
@AllArgsConstructor
@NoArgsConstructor
public class Car {
	
	@Id
	int cid;
	String carName;
	String carEngine;
	LocalDateTime launch;
	double price;
	boolean isSUV = false;
	
}
