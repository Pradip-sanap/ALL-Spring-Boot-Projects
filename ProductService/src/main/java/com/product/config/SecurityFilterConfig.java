package com.product.config;

import com.product.jwt.JWTAuthenticationFilter;
import com.product.jwt.JwtAuthenticationEntryPoint;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class SecurityFilterConfig {

    private JwtAuthenticationEntryPoint point;
    private JWTAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        return security.csrf(csrf-> csrf.disable())  		//Cross-site request forgery
                .cors(cors-> cors.disable())				//Cross-Origin Resource Sharing
                .authorizeHttpRequests(
                		auth->auth.requestMatchers("/authenticate").permitAll().anyRequest().authenticated()
                )
                .exceptionHandling(ex ->ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }
}