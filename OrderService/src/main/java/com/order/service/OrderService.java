package com.order.service;

import java.util.List;

import com.order.dto.OrderDto;

public interface OrderService {
	
	/**
     * Places a new customer order.
     *
     * <p>This method accepts an {@link com.order.dto.OrderDto} containing the order details, processes
     * the order placement, and returns the resulting saved order object. If the order cannot be saved,
     * the method returns {@code null}.
     *
     * @param orderDto the data transfer object containing the order details for placement
     * @return the saved order object if the order is successfully placed, or {@code null} otherwise
     */
    public Object placedOrder(OrderDto orderDto);
    
    /**
     * Retrieves an order by its unique identifier.
     *
     * <p>This method fetches the order details corresponding to the provided order ID and returns
     * an {@link com.order.dto.OrderDto} representing the order.
     *
     * @param orderId the unique identifier of the order to retrieve
     * @return an {@link com.order.dto.OrderDto} object containing the order details
     */
    public OrderDto getOrderById(int orderId);
    
    /**
     * Retrieves all orders placed by a specific customer.
     *
     * <p>This method fetches all orders associated with the specified customer ID and returns them
     * as a list of {@link com.order.dto.OrderDto} objects.
     *
     * @param customerId the unique identifier of the customer whose orders are to be retrieved
     * @return a {@link List} of {@link com.order.dto.OrderDto} objects representing the customer's orders
     */
    public List<OrderDto> getOrdersOfCustomer(String customerId);
}
