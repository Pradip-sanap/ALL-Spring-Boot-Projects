package com.order.product.apiservice;

import com.order.entity.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductApiService {
	
	@GET("product/{id}")
    Call<Product> getProductById(@Path("id") int id);

    @PUT("product/{id}/{quantity}")
    Call<Boolean> updateQuantityOfProduct(@Path("id") int id, @Path("quantity") int quantity);

}
