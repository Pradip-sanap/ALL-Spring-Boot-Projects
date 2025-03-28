//package com.product.cotnroller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.product.dto.JwtRequest;
//import com.product.dto.JwtResponse;
//import com.product.jwt.JwtUtil;
//
//@RestController
//@RequestMapping("api/auth")
//public class AuthController {
//	
//	@Autowired
//	private JwtUtil jwtUtil;
//
//	@PostMapping("/login")
//	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest){
//		
//		if("user123".equals(jwtRequest.getUsername()) && "password123".equals(jwtRequest.getPassword())) {
//			//generate Token
//			String token = jwtUtil.generateToken(jwtRequest.getUsername());
//			
//			return ResponseEntity.ok(new JwtResponse(jwtRequest.getUsername(), token));
//		} else {
//			return ResponseEntity.status(401).body(null);
//		} 
//	}
//	
//	@GetMapping("/validate")
//	public ResponseEntity<String> validateToken(@RequestHeader("Authorization") String authHeader){
//		if(authHeader == null || !authHeader.startsWith("Bearer_")) {
//			return ResponseEntity.status(400).body("Invalid Authorization Header !!");
//		}
//		
//		String token = authHeader.substring(7);
//		
//		if(jwtUtil.validateToken(token)) {
//			String userId = jwtUtil.extractUserId(token);
//			return ResponseEntity.ok("Token is valid!!");
//		}else {
//			return ResponseEntity.status(401).body("Invalid Token");
//		} 
//	}
//	
//	
//}
