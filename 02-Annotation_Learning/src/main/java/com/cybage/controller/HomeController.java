package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.entity.User;

@RestController
public class HomeController {

	@Autowired
	@Lazy
	private User user;

	@GetMapping("home")
	public String getUser() {
		return user.toString();
	}

//    @GetMapping("/session")
//    public String testSessionScope() {
//        return "Session Bean ID: " + user.getId() +
//               ", Created At: " + user.getCreatedAt();
//    }
}