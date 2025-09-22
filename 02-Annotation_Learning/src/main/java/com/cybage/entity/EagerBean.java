package com.cybage.entity;

import org.springframework.stereotype.Component;

@Component
public class EagerBean {

	public EagerBean() {
		super();
		System.out.println("Eagerly Bean creted");
	}
	
	
	
}
