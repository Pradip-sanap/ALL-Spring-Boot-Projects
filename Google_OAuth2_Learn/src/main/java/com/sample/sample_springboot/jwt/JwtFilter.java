package com.sample.sample_springboot.jwt;

import io.jsonwebtoken.Jwt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Request processing in JWT filter: {}", request.getServletPath());
        // bypass JWT validation for new user registration api. This api did not need token during registration
        String path = request.getServletPath();
        if (path.equals("/api/user") && request.getMethod().equalsIgnoreCase("POST")) {
            log.debug("Skipping JWT filter for user registration endpoint: {}", path);
            filterChain.doFilter(request, response);
            return;
        }


        String authHeader = request.getHeader("Authorization");
        try {
            if (authHeader != null && authHeader.startsWith("Bearer_")) {
                String token = authHeader.substring(7);

                if (jwtUtil.validateToken(token)) {
                    String username = jwtUtil.extractUsername(token);
//                    UserDetails user = userService.loadUserByUsername(username);
                    UserDetails user = User.builder()
                            .username(username)
                            .password("") // not needed
                            .authorities(List.of()) // or roles if you want
                            .build();

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    log.debug("JWT token validated successfully for username={}", username);
                } else {
                    log.warn("Invalid JWT token received");
                }
            } else {
                log.warn("Authorization header missing or does not start with Bearer");
            }
        } catch (Exception ex) {
            log.error("Error validating JWT token", ex);
        }



        filterChain.doFilter(request, response);
    }
}
