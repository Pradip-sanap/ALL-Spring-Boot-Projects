package com.rsa.totp.model;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String secret;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }



}
