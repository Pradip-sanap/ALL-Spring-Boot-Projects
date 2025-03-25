package com.order.utility;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value; 
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtility {

	@Value("${jwt.secret}")
	private String secretKey;

	@Value("${jwt.expiration}")
	private long jwtExpirationInMs;

	public String getJwtToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, username);
	}

	// Create token
	private String createToken(Map<String, Object> claims, String username) {
		Date now = new Date(jwtExpirationInMs);
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(now).setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}

}
