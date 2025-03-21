package com.order.service;
 
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Product;

import brave.Tracer;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class RetrofitInstance {

	public static final String BASE_URL = "http://localhost:8080/";
	private static ApiInterface apiInterface;
	@Autowired
	private  Tracer tracer;

	public RetrofitInstance() {  

        OkHttpClient client = new OkHttpClient.Builder() 
                .build();
		Retrofit retrofit = new Retrofit.Builder()
					.baseUrl(BASE_URL)
					.addConverterFactory(GsonConverterFactory.create())
					.client(client)
					.build(); 
		apiInterface = retrofit.create(ApiInterface.class);
	} 
	
	
	public Product getProductById(int id) { 
		try { 
			Call<Product> call = apiInterface.getProductById(id); 
			Response<Product> response = call.execute(); 
			return response.body();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateQuantityOfProductAfterBuying(int productid, int quantity) {
		try {
			Call<Boolean> isQuantityUpdated = apiInterface.updateQuantityOfProduct(productid, quantity);
			Response<Boolean> response = isQuantityUpdated.execute();
			boolean result = response.body();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
