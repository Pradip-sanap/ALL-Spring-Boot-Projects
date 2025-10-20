package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String home() {
        return "home"; // Renders home.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Renders login.html
    }
    
    @GetMapping("/secure")
    public String secure() {
        return "secure"; // Renders secure.html
    }
}