package com.dev.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

//	private  Engine engine;  

//	1. contructor injection 
//    @Autowired 
//    public Car(@Qualifier("dieselbean") Engine engine) {   // ✅ Constructor Injection
//        this.engine = engine;
//    }

//    2. Setter injection
//    @Autowired
//    public void setEngine(@Qualifier("dieselbean") Engine engine) {   // ✅ Setter Injection
//        this.engine = engine;
//    }

//    3.Field injection
	@Autowired
//	@Qualifier("petrolbean")
	@Qualifier("dieselbean")
	Engine engine;

	public void drive() {
		engine.type();
		System.out.println("Car is driving...");
	}
}
