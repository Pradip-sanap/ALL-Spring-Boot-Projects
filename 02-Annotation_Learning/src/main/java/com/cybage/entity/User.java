package com.cybage.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
//@Scope(value = WebApplicationContexwt.SCOPE_REQUEST, proxyMode  = ScopedProxyMode.TARGET_CLASS)
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode  = ScopedProxyMode.TARGET_CLASS)
//@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode  = ScopedProxyMode.TARGET_CLASS)
//@Scope("websocket")
@AllArgsConstructor
//@NoArgsConstructor
@Lazy
public class User {

	int userId;
	
	String username;
	
	public User() {
		System.out.println("User contructor called.");
	}

	 
}
