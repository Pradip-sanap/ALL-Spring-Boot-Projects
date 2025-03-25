package com.order.service.impl; 

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;  
import com.order.dto.OrderDto;
import com.order.entity.Order;
import com.order.entity.Product; 
import com.order.repository.OrderRepository;
import com.order.service.ApiInterface;
import com.order.service.OrderService;
//import com.order.service.RetrofitInstance;

//import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
  

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
//    private final RetrofitInstance retrofitInstance;
    private final ApiInterface apiInterface;
//    private final Tracer tracer;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, 
                            ModelMapper modelMapper, 
                            ApiInterface apiInterface
//                            Tracer tracer
                            ) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.apiInterface = apiInterface;
//        this.tracer = tracer;
    }
	 
	
	@Override
	public Object placedOrder(OrderDto orderDto) {  
		// Log Trace ID and Span ID
//        log.info("Trace ID: {}, Span ID: {}", 
//                 tracer.currentSpan().context().traceIdString(), 
//                 tracer.currentSpan().context().spanIdString());
		Product productObj = apiInterface.getProductById(orderDto.getProductId());  
 
		if(!productObj.isInStock()) {
			return "Product Out of stock. Apologies !!!";
		}
		
		Order newOrder =  modelMapper.map(orderDto, Order.class);
		newOrder.setProductId(productObj.getPid());
		newOrder.setProductName(productObj.getProductName());
		newOrder.setCategory(productObj.getCategory());
		newOrder.setPrice(productObj.getPrice());
		newOrder.setColor(productObj.getColor()); 
		
		Order savedOrder =  orderRepository.save(newOrder);
		
		//update the quantity
		boolean isQuantityUpdated = apiInterface.updateQuantityOfProductAfterBuying(
													orderDto.getProductId(), 
													orderDto.getQuantity()
												);
		if(isQuantityUpdated) {
			System.out.println("Quantity also updated ----->");
		}else {
			System.out.println("Not update quantity *****");
		}
		
		
		return modelMapper.map(savedOrder, OrderDto.class);
	}



	@Override
	public OrderDto getOrderById(int orderId) {

		Optional<Order> orderDetails = orderRepository.findById(orderId);
		try {
			if(orderDetails.isPresent()) {
				return modelMapper.map(orderDetails.get(), OrderDto.class);
			}
			else {
				throw new Exception("Invalide Order id");
			}
		} catch (Exception e) {
			e.printStackTrace();  // Optionally log the error for debugging purposes
	        return null;
		} 
		 
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDto> getOrdersOfCustomer(String customerId) {
		try {
			List<Order> orders =  orderRepository.findByCustomerId(customerId);
			 if (orders.isEmpty()) {
		            return null;  // Return null if no orders found
		        } else {
		            // Convert each Order to an OrderDto and return the list
		            return orders.stream()
		                         .map(order -> modelMapper.map(order, OrderDto.class))
		                         .collect(Collectors.toList());
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
