package com.auth.service;
 
import java.util.Random;

import org.springframework.stereotype.Service;
 

@Service
public class AuthenticationOTPServiceImpl implements AuthenticationOTPService {
	private static final long VALIDITY_DURATION_MS = 60 * 1000; // 60 seconds
    private static long lastGeneratedTime = 0;
    private static String currentOtp = null;

    @Override
    public String getOtp() {
    	long now = System.currentTimeMillis();
    	System.out.println("Now millis->"+now);

        // If no OTP generated yet or 60 seconds passed, generate new OTP
        if (currentOtp == null || now - lastGeneratedTime >= VALIDITY_DURATION_MS) {
            currentOtp = generateRandomOtp(8);
            lastGeneratedTime = now;
        }
        return currentOtp;
    }
    
    private static String generateRandomOtp(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10)); // digits 0-9
        }
        return sb.toString();
    }

}
