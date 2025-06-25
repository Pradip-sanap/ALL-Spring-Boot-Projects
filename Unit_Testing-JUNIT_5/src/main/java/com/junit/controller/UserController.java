package com.junit.controller;
 
 

import java.util.Optional;

import com.junit.model.User;
import com.junit.service.UserService;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String register(User user) {
        try {
            User saved = userService.registerUser(user);
            return "User registered: " + saved.getId();
        } catch (IllegalArgumentException e) {
            return "Registration failed: " + e.getMessage();
        }
    }

    public String getUser(Long id) {
        Optional<User> user = userService.getUser(id);
        return user.map(u -> "User: " + u.getName())
                   .orElse("User not found");
    }
}

