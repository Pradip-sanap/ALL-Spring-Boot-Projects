package com.dev.app.service;

import org.springframework.stereotype.Component;

@Component("dieselbean")
public class DieselEngine implements Engine{
	
	

	@Override
	public void type() {
		System.out.println("Diesel engine");
		
	}

}
