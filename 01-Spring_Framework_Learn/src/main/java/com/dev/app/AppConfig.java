package com.dev.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dev.app.model.Book;
import com.dev.app.model.Product;
import com.dev.app.service.ProductService;

@Configuration
@ComponentScan(basePackages = "com.dev.app")		//If we include this annotation, then no need for manual
													// @Bean declaration, it automatically scan for stereotype annotation to create Bean.
public class AppConfig {
	
//	@Bean
//    public Book book() {
//        Book b = new Book();
//        b.setBid(101);
//        b.setBookname("Ikigai");
//        return b;
//    }
//	
//	@Bean
//	public Product product() {
//		Product p = new Product(111,"watch",8000.30, "available");
//		return p;
//		
//	}
//	
//	@Bean
//	public ProductService productService() {
//		return new ProductService();
//	}

}
