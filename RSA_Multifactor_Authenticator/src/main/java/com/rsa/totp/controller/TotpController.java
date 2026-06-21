package com.rsa.totp.controller;

import com.rsa.totp.service.TotpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
@Slf4j
public class TotpController {

    private final TotpService totpService;

    @GetMapping
    public String getToken() {
        log.info("Request for RSA Token.");
        String TokenCode = totpService.generateToken();
        log.info("Token Code: {}", TokenCode);
        return TokenCode;
    }
}
