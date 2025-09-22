package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.service.MobileServiceImpl;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	@Autowired
	MobileServiceImpl service;
	
	@GetMapping
	public boolean operation() {
//		service.saveMobile();
		service.saveAll();
		return true;
	}
}
