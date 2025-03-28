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

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	 
	@PostMapping("")
	public ResponseEntity<Object> placedOrder(@RequestBody OrderDto orderDto){ 
		return new ResponseEntity<>(orderService.placedOrder(orderDto), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") int id){
		return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/cust/{custId}")
	public ResponseEntity<List<OrderDto>> getOrderByCustomerId(@PathVariable("custId") String id){
		return new ResponseEntity<>(orderService.getOrdersOfCustomer(id), HttpStatus.OK);
	}

}
