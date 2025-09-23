package com.security.config;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.security.filters.CustomLoggingFilter;
import com.security.filters.SimpleTokenFilter;
import com.security.filters.TokenService;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	private final TokenService tokenService;

    public SecurityConfig(TokenService tokenService) {
        this.tokenService = tokenService;
    }
	
	@Bean
	public CustomLoggingFilter loggingFilter() {
		return new CustomLoggingFilter();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		
		
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
					 .requestMatchers("/public/**").permitAll()
		             .anyRequest().authenticated()		
			)
			.formLogin(Customizer.withDefaults())
			.httpBasic(Customizer.withDefaults());
		
		http.addFilterBefore(loggingFilter(), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
//	@Bean
//    public SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable())
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/public/**").permitAll()
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//            )
//            .httpBasic(Customizer.withDefaults());
//
//    
//        // add custom token filter before UsernamePasswordAuthenticationFilter
//        http.addFilterBefore(new SimpleTokenFilter(tokenService), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
	
	@Bean
    public UserDetailsService users() {
        var user = User.withUsername("user")
                       .password(passwordEncoder().encode("password"))
                       .roles("USER")
                       .build();
        return new InMemoryUserDetailsManager(user);
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}


	  
	


