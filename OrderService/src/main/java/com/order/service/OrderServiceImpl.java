package com.order.service; 

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;  
import com.order.dto.OrderDto;
import com.order.entity.Order;
import com.order.entity.Product;
import com.order.product.apiservice.ProductService; 
import com.order.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;
  

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	 
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private brave.Tracer tracer;
	
	@Override
	public Object placedOrder(OrderDto orderDto) {
		System.out.println("Inside order service -->"+ orderDto); 
		Product productObj = productService.getProductById(orderDto.getProductId());
		System.out.println("Final Result ******>>>>>>>"+productObj);
		
		// Log trace and span ID
        log.info("TraceId: {}, SpanId: {}", tracer.currentSpan().context().traceId(), tracer.currentSpan().context().spanId());

		
		if(!productObj.isInStock()) {
			return "Product Out of stock. Apologies !!!";
		}
		
		Order newOrder =  modelMapper.map(orderDto, Order.class);
		newOrder.setProductId(productObj.getPid());
		newOrder.setProductName(productObj.getProductName());
		newOrder.setCategory(productObj.getCategory());
		newOrder.setPrice(productObj.getPrice());
		newOrder.setColor(productObj.getColor());
		
		System.out.println("New Order before storing into database --->"+newOrder);
		
		Order savedOrder =  orderRepository.save(newOrder);
		
		//update the quantity
		boolean isQuantityUpdated = productService.updateQuantityOfProductAfterBuying(
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
