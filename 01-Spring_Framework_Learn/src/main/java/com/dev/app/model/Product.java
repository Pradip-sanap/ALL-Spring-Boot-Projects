package com.dev.app.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements InitializingBean, DisposableBean {
	int pid;
	String pname;
	double price;
	String sku;

	@Override
	public void destroy() throws Exception {
		System.out.println("Destory method called at last");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init method called.");

	}

}
