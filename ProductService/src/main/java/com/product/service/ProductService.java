package com.product.service;

import org.springframework.stereotype.Service;

import com.product.dto.ProductDto;
 


public interface ProductService {
	
	/**
	 * Add the product by providing new Product DTO Object.
	 * 
	 * @return Save user object if data save succssfully in db, null otherwise.
	 */
	public ProductDto addProduct(ProductDto productDto);
	
	/**
	 * Fetch the product by providing new product DTO Object.
	 *  
	 * @return product object if data present in db, null otherwise.
	 */
	public ProductDto getProduct(int id);
	
	/**
	 * Delete the product with provided product id.
	 * 
	 * @return String value w.r.t operation.
	 */
	public String deleteProduct(int id);

	/**
	 * Update the product by providing productId and new Updated values.
	 *
	 * @param id must not be null.
	 * @param new values as productDto object type.
	 * @return {@literal User Object} if an entity with the given id exists, {@literal String} otherwise.
	 */
	public Object updateProduct(int id, ProductDto newValues);
	
	/**
	 * Update the quantity when product buy by providing productId and quantity.
	 * 
	 * @return {@literal User Object} if an entity with the given id exists, {@literal String} otherwise.
	 */
	public boolean decreaseQuantityForProductBy(int id, int quantity);


}
