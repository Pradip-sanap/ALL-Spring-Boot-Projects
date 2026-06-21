package com.rsa.totp.controller;

import com.rsa.totp.model.LoginRequest;
import com.rsa.totp.service.TotpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final TotpService totpService;

    @PostMapping("/login")
    public String login(  @RequestBody LoginRequest request ) {

        boolean valid = totpService.validateToken(request.getToken());

        if (!valid) {
            return "INVALID TOKEN";
        }

        // username/password validation here

        return "LOGIN SUCCESS";
    }
}