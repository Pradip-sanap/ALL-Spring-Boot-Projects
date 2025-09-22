package com.dev.app.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Book 
//		implements InitializingBean, DisposableBean
{
	
	@Value("101")
	int bid;

	@Value("Ikigai")
	String bookname;

	public Book() {
		super();
	} 

	@PostConstruct
	public void initMethod() {
		System.out.println("Inside BOOK init method");
	}

	@PreDestroy
	public void destroyMethod() {
		System.out.println("Inside BOOK destroy method");
	}
 
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public void destroy() throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

}
