package com.sample.sample_springboot.security;

import com.sample.sample_springboot.jwt.JwtUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
         OAuth2AuthenticationToken details = (OAuth2AuthenticationToken) authentication;
//        System.out.println("Inside success handler Token-->{}" + token);
         log.info("Inside success handler Token-->{}", details);
         OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
//        System.out.println("oAuth2User ->{}" + oAuth2User);
        log.info("oAuth2User ->{}", oAuth2User);

        String registrationId = details.getAuthorizedClientRegistrationId();

        String email = oAuth2User.getAttribute("email");

        // generate JWT here
        String accessToken = jwtUtil.generateAccessToken(email);
        // send token in response
//        response.setHeader("application/json", accessToken);
//        response.setContentType("application/json");
//        response.getWriter().write("{\"token\": \"" + accessToken + "\"}");

//        response.sendRedirect("/api/v1/hello");


        response.sendRedirect("http://localhost:5500/index.html?token=" + accessToken);

    }
}
