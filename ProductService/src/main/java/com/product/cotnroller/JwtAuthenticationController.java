package com.product.cotnroller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.JwtRequest;
import com.product.dto.JwtResponse;
import com.product.jwt.JwtHelper;

@RestController
@AllArgsConstructor
@Slf4j
public class JwtAuthenticationController {

	private UserDetailsService userDetailsService;

	private AuthenticationManager manager;

	private JwtHelper jwtHelper;

	@PostMapping("/authenticate")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) { 
		this.doAuthenticate(request.getUsername(), request.getPassword());
 
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());   

		String token = this.jwtHelper.generateToken(userDetails);
		log.debug("Token signed successfully : {}", token);

		JwtResponse response = JwtResponse.builder()
								.jwtToken(token)
								.username(request.getUsername())
								.build();
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	private void doAuthenticate(String username, String password) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
		try {
			manager.authenticate(authentication);
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Credentials Invalid !!");
		}

	}
}
