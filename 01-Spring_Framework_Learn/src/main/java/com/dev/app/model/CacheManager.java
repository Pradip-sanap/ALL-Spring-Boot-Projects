package com.dev.app.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Scope("prototype")
//@Data
public class CacheManager {
	
	String data;

	int count = 0;
	public CacheManager() {
		count++;
		System.out.println("Cache manager called." + count);
	}
}
