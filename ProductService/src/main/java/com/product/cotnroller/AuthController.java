package com.product.cotnroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.product.entity.User;
import com.product.repository.UserRepository;
import com.product.utility.JwtUtility;

@RestController
@RequestMapping("/product/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtility jwtUtility;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User authRequest) {
		try {
			User existingUser = userRepository.findByUserName(authRequest.getUserName());
			if(existingUser == null) {
				throw new Exception("Invalid user");
			}
			if(existingUser.getUserName().equals(authRequest.getUserName()) && 
		            existingUser.getPassword().equals(authRequest.getPassword())) {
				String token = jwtUtility.getJwtToken(authRequest.getUserName());
				return ResponseEntity.ok(token);
				
			}
		} catch (Exception e) {
			// Log the exception and return 401 Unauthorized
	        e.printStackTrace();
	        return ResponseEntity.status(401).body("Unauthorized: " + e.getMessage());

		}
		return null;
		

	}

}
