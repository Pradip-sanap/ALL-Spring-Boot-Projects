package com.cybage.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("user/{id}")
	public Object getUser(@PathVariable("id") int id) {
		System.out.println("User id: " + id);
		if (id < 0) {
			throw new IllegalArgumentException("Invalid user ID: " + id);
		}
		return "User " + id;
	}

//	@ExceptionHandler(IllegalArgumentException.class)
//	public String handleIllegalArgument(IllegalArgumentException ex) {
//		System.out.println("Exception -->"+ ex.getLocalizedMessage());
//		return "Error: " + ex.getMessage();
//	}
}
