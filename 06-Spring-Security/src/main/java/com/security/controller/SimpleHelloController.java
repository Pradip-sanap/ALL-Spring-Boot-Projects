package com.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SimpleHelloController {

    @GetMapping("/home")
    public String greet(HttpServletRequest req) {
        return "Welcome to home page" + req.getSession().getId();
    }

    @GetMapping("/public/hello")
    public String publicHello() {
        return "public";
    }

    @GetMapping("/private/hello")
    public String privateHello(Authentication a) {
        return "hello " + a.getName();
    }

}
