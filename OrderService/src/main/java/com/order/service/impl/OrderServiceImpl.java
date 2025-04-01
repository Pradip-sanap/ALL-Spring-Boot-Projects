package com.order.service.impl; 

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.order.dto.JwtRequest;
import com.order.dto.JwtResponse;
import com.order.dto.OrderDto;
import com.order.entity.Order;
import com.order.entity.Product; 
import com.order.repository.OrderRepository;
import com.order.service.ApiInterface;
import com.order.service.OrderService;
//import com.order.service.RetrofitInstance;

import lombok.AllArgsConstructor;
//import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
  

@Service
@Slf4j 
public class OrderServiceImpl implements OrderService {

	@Autowired
	private  OrderRepository orderRepository;
	
	@Autowired
    private  ModelMapper modelMapper; 
	
	@Autowired
    private  ApiInterface apiInterface; 
	
	@Override
	public Object placedOrder(OrderDto orderDto) {
		
		JwtResponse token = apiInterface.getToken(new JwtRequest("admin", "admin"));
		log.debug("Token is ::"+token.getJwtToken());
		
		String jwttoken = "Bearer_"+token.getJwtToken();
		log.debug("Bearer Token ::"+jwttoken);

		Product productObj = apiInterface.getProductById(orderDto.getProductId(), jwttoken);
		log.debug("Product details successfully fetch frpm Product service");

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
		log.info("Order saved successfully.");
		
		//update the quantity
		boolean isQuantityUpdated = apiInterface.updateQuantityOfProductAfterBuying(
													orderDto.getProductId(), 
													orderDto.getQuantity(),
													jwttoken
												);
		if(isQuantityUpdated) {
			log.info("After purchase, Quantity Of product updated successfully.");
		}else {
			log.error("Error while updating product quantity.");
		}
		
		
		return modelMapper.map(savedOrder, OrderDto.class);
	}



	@Override
	public OrderDto getOrderById(int orderId) {

		try {
			Optional<Order> orderDetails = orderRepository.findById(orderId);
			
			if(orderDetails.isPresent()) {
				return modelMapper.map(orderDetails.get(), OrderDto.class);
			}
			else {
				throw new Exception("Invalide Order id");
			}
		} catch (Exception e) {
			e.printStackTrace();
	        return null;
		} 
		 
	}


 
	@Override
	public List<OrderDto> getOrdersOfCustomer(String customerId) {
		
		try {
			
			List<Order> orders =  orderRepository.findByCustomerId(customerId);
			 if (orders.isEmpty()) {
		            return null;   
		        } else {
	
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
