package com.rsa.totp.controller;

import com.rsa.totp.db.UserDB;
import com.rsa.totp.dto.VerifyRequest;
import com.rsa.totp.model.User;
import com.rsa.totp.service.QRCodeService;
import com.rsa.totp.service.TotpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final TotpService totpService;

    private final QRCodeService qrCodeService;

    private final UserDB userDB;

    @GetMapping(
            value = "/setup/{username}",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public byte[] setup(@PathVariable String username) throws Exception {

        String secret = totpService.generateSecret();

        // save secret in DB
        userDB.saveSecretForUserUsingUsername(username, secret);

        String url = totpService.getOtpAuthURL(
                        "MyApp",
                        username,
                        secret
                );

        return qrCodeService.generateQRCode(url);
    }

    @PostMapping("/verify")
    public String verify(@RequestBody VerifyRequest request) {

        // get user from DB
        User user = userDB.getUserFromDBUsingUsername(request.getUsername());

        String secret = user.getSecret();

        boolean valid = totpService.verify(
                        secret,
                        request.getCode()
                );

        if (valid) {
            return "VALID";
        }

        return "INVALID";
    }
}
