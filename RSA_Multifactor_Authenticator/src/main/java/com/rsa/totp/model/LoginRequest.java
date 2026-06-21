package com.rsa.totp.model;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
    private String token;
}