package com.security.filters;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    // Fake validation: "valid-token" belongs to "user"
    // In real-world: decode JWT, verify signature, expiration, claims etc.
    public UserDetails validateAndGetUser(String token) {
        if ("valid-token".equals(token)) {
            return User.withUsername("user")
                       .password("") // not needed for token-based auth
                       .authorities(List.of(new SimpleGrantedAuthority("ROLE_USER")))
                       .build();
        }
        if ("admin-token".equals(token)) {
            return User.withUsername("admin")
                       .password("")
                       .authorities(List.of(new SimpleGrantedAuthority("ROLE_ADMIN")))
                       .build();
        }
        return null; // invalid token
    }
}