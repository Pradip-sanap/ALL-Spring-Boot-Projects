//package com.product.jwt;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.SignatureException;
//import lombok.extern.slf4j.Slf4j;
//
//@Component
//@Slf4j
//public class JwtUtil {
//
//	@Value("${jwt.secret}")
//	private String secretKey;
//	public String generateToken(String userName) {
//		
//		long nowMillis = System.currentTimeMillis();
//		long expMillis = nowMillis * 1000 * 60 * 60;
//		Date exp = new Date(expMillis);
//		
//		return Jwts.builder()
//			.setSubject(userName)
//			.setIssuedAt(new Date(nowMillis))
//			.setExpiration(exp)
//			.signWith(SignatureAlgorithm.HS256, secretKey)
//			.compact(); 
//	}
//	public boolean validateToken(String token) {
//		// TODO Auto-generated method stub
//		String[] parts = token.split("\\.");
//		if(parts.length != 3) {
//			log.error("Unexpected Token length");
//			return false;
//		}
//		
//		try {
//			Claims claims = Jwts.parser()
//					.setSigningKey(secretKey)
//					.parseClaimsJws(token)
//					.getBody();
//			String userId = claims.getSubject();
//			
//			Date expiration = claims.getExpiration();
//			
//			System.out.println("User Id->" + userId);
//			System.out.println("Expiration -> "+ expiration);
//	
//			return true;
//		} catch (SignatureException e) {
//			log.error("Signature in token are invalid");
//			return false;
//		} catch( Exception e) {
//			log.error("Something unexpexted happen");
//			return false;
//		}
//	}
//	public String extractUserId(String token) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
