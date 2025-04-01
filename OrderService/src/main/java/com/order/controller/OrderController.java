package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.OrderDto;
import com.order.entity.Product;
import com.order.service.OrderService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
@Slf4j
public class OrderController {
	
	private OrderService orderService;

	/**
	 * Places a new order.
	 *
	 * <p>This method handles HTTP POST requests to create a new order. It accepts an 
	 * {@link com.order.dto.OrderDto} object containing the order details, delegates the processing 
	 * to the {@link com.order.service.OrderService#placedOrder(OrderDto)} method, and returns a 
	 * {@link ResponseEntity} containing the order placement result with an HTTP status of 201 (CREATED).
	 *
	 * @param orderDto the data transfer object containing the order details for placement
	 * @return a {@link ResponseEntity} with the order placement result and HTTP status 201 (CREATED)
	 */
	@PostMapping("")
	public ResponseEntity<Object> placedOrder(@RequestBody OrderDto orderDto){ 
		log.debug("Placing order with details: {}", orderDto);
		return new ResponseEntity<>(
				orderService.placedOrder(orderDto), 
				HttpStatus.CREATED
		);
	}
	
	/**
	 * Retrieves an order by its identifier.
	 *
	 * <p>This method handles HTTP GET requests for fetching a specific order by its ID.
	 * The order details are obtained via the {@link OrderService} and returned in a
	 * {@link ResponseEntity} with HTTP status OK.
	 *
	 * @param id the unique identifier of the order
	 * @return a {@link ResponseEntity} containing the {@link OrderDto} and HTTP status 200 (OK)
	 */
	@GetMapping("/{id}")
	public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") int id){
		log.debug("Inside OrderController-getOrderById: orderId={}", id); 
		return new ResponseEntity<>(
				orderService.getOrderById(id), 
				HttpStatus.OK
		);
	}
	
	/**
	 * Retrieves all orders placed by a specific customer.
	 *
	 * <p>This method handles HTTP GET requests to fetch all orders associated with a particular customer.
	 * It delegates the retrieval logic to the {@link com.order.service.OrderService#getOrdersOfCustomer(String)} method and returns the
	 * resulting list of orders wrapped in a {@link ResponseEntity} with an HTTP status code of 200 (OK).
	 *
	 * @param custId the unique identifier of the customer whose orders are to be retrieved
	 * @return a {@link ResponseEntity} containing a list of {@link com.order.dto.OrderDto} representing the orders for the specified customer
	 */
	@GetMapping("/cust/{custId}")
	public ResponseEntity<List<OrderDto>> getOrderByCustomerId(@PathVariable("custId") String id){
		log.debug("Inside OrderController-getOrderByCustomerId: custId={}", id); 
		return new ResponseEntity<>(
				orderService.getOrdersOfCustomer(id), 
				HttpStatus.OK
		);
	}

}
