package com.order.service;

import java.net.http.HttpHeaders;

import org.apache.tomcat.util.http.parser.HttpHeaderParser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.order.dto.JwtRequest;
import com.order.dto.JwtResponse;
import com.order.entity.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

@FeignClient(name = "user-service", url = "http://localhost:8080")
public interface ApiInterface {

	@PostMapping("/authenticate")
	JwtResponse getToken(@RequestBody JwtRequest jwtRequest);
	
	@GetMapping("/product/{id}")
	Product getProductById(@PathVariable("id") int id, @RequestHeader("Authorization") String token);
	
	@PutMapping("product/{id}/{quantity}")
	Boolean updateQuantityOfProductAfterBuying(
			@PathVariable("id") int id, 
			@PathVariable("quantity") int quantity, 
			@RequestHeader("Authorization") String token
	); 

}
