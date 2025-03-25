package com.order.service;
 
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.order.entity.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

@FeignClient(name = "user-service", url = "http://localhost:8080")
public interface ApiInterface {
	
	 @GetMapping("/product/{id}")
	 Product getProductById(@PathVariable("id") int id);
	 
	 @PutMapping("product/{id}/{quantity}")
	 Boolean updateQuantityOfProductAfterBuying(@PathVariable("id") int id, @PathVariable("quantity") int quantity);
//	@GET("product/{id}")      
//    Call<Product> getProductById(@Path("id") int id);

//    @PUT("product/{id}/{quantity}")
//    Call<Boolean> updateQuantityOfProduct(@Path("id") int id, @Path("quantity") int quantity);

}
