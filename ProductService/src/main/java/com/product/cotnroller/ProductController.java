package com.product.cotnroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductDto;
import com.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@Autowired
	private ProductService productService; 
	
	 
	@PostMapping("")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) { 
		try {
			ProductDto result = productService.addProduct(productDto);
			if(result != null) {
				return new ResponseEntity<ProductDto>(result, HttpStatus.CREATED);
			}
			return ResponseEntity.badRequest().body(null);
			
		} catch (Exception e) {
			e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
	}
	
	 
	@GetMapping("/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable("id") int id){  

		try {
			return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
			
		} catch (Exception e) {
			e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		try {
			return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
		} catch (Exception e) {
			e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
 
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody ProductDto newValues){
		return new ResponseEntity<>(productService.updateProduct(id, newValues), HttpStatus.OK);
	}
	
	 
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
		return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
	}
	
	 
	@PutMapping("/{id}/{quantity}")
	public ResponseEntity<Boolean> decreaseQuantityForProductBy(@PathVariable("id") int id, @PathVariable("quantity") int quantity) {
		return new ResponseEntity<>(productService.decreaseQuantityForProductBy(id, quantity), HttpStatus.OK);
	}
}
