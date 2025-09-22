package com.dev.app.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("petrolbean")
//@Primary
public class PetrolEngine implements Engine{

	@Override
	public void type() {
		System.out.println("Petrol engine");
		
	}

}
