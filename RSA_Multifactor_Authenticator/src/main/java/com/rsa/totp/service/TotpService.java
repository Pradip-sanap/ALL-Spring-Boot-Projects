package com.rsa.totp.service;

import dev.samstevens.totp.code.DefaultCodeGenerator;
import dev.samstevens.totp.code.DefaultCodeVerifier;
import dev.samstevens.totp.exceptions.CodeGenerationException;
import dev.samstevens.totp.secret.DefaultSecretGenerator;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TotpService {

    private final String SECRET = "MY_SUPER_SECRET_KEY";


    public String generateToken() {
        TimeProvider timeProvider = new SystemTimeProvider();
        log.info("Current Time: {}", timeProvider.getTime());

        long currentBucket = Math.floorDiv(
                timeProvider.getTime(),
                60
        );
        log.info("CurrentBucket: {}", currentBucket);

        DefaultCodeGenerator generator =
                new DefaultCodeGenerator();

        try {
            return generator.generate(
                    SECRET,
                    currentBucket
            );
        } catch (CodeGenerationException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateToken(String tokenCode) {
        String generateToken = generateToken();
        if (generateToken.equals(tokenCode)) {
            return true;
        }
        return false;
    }

    public String generateSecret() {

        DefaultSecretGenerator generator =
                new DefaultSecretGenerator();

        return generator.generate();
    }

    public String getOtpAuthURL(
            String appName,
            String username,
            String secret
    ) {

        return String.format(
                "otpauth://totp/%s:%s?secret=%s&issuer=%s",
                appName,
                username,
                secret,
                appName
        );
    }


    public boolean verify(String secret, String code) {
        DefaultCodeVerifier verifier = new DefaultCodeVerifier(
                        new DefaultCodeGenerator(),
                        new SystemTimeProvider()
                );

        verifier.setTimePeriod(30);

        verifier.setAllowedTimePeriodDiscrepancy(1);

        return verifier.isValidCode(
                secret,
                code
        );
    }

}
