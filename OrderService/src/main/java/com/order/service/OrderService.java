package com.order.service;

import java.util.List;

import com.order.dto.OrderDto;

public interface OrderService {
	
	public Object  placedOrder(OrderDto orderDto);
	
	public OrderDto getOrderById(int orderId);
	
	public List<OrderDto> getOrdersOfCustomer(String customerId);
}
