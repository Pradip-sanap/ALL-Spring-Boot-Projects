//package com.order.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.order.entity.User;
//import com.order.repository.UserRepository;
//import com.order.utility.JwtUtility;
//
//@RestController
//@RequestMapping("/orders") 
//public class AuthController {
//
//	@Autowired
//	private UserRepository userRepository;
//	
////	@Autowired
////    private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private JwtUtility jwtUtility;
//
//	@PostMapping("/auth")
//	public ResponseEntity<String> login(@RequestBody User authRequest) {
//		try {
//			 User existingUser = userRepository.findByUserName(authRequest.getUserName());
//			System.out.println(existingUser);
//			if(existingUser == null) {
//				throw new Exception("Invalid user");
//			}
//			if(existingUser.getUserName().equals(authRequest.getUserName()) && 
//		            existingUser.getPassword().equals(authRequest.getPassword())) {
//				String token = jwtUtility.getJwtToken(authRequest.getUserName());
//				return ResponseEntity.ok(token);
//				
//			}
//		} catch (Exception e) {
//			// Log the exception and return 401 Unauthorized
//	        e.printStackTrace();
//	        return ResponseEntity.status(401).body("Unauthorized: " + e.getMessage());
//
//		}
//		return null;
//		
//
//	}
//
//}