package com.cybage.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class LazyBean {

	public LazyBean() {
		super();
		System.out.println("LazyBean Bean creted");
	}
	
	public void showMe() {
		System.out.println("SHow me method");
	}
	
	
	
}