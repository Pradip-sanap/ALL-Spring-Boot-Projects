package com.rsa.totp.dto;

import lombok.Data;

@Data
public class VerifyRequest {
    private String username;

    private String code;
}
