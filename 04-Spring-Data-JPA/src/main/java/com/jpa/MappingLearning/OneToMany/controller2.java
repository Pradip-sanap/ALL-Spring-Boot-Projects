package com.jpa.MappingLearning.OneToMany;

import com.jpa.MappingLearning.OneToOne.Address;
import com.jpa.MappingLearning.OneToOne.Employee;
import com.jpa.repository.AddressRepository;
import com.jpa.repository.CustomerRepo;
import com.jpa.repository.EmployeeRepository;
import com.jpa.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/oneToMany")
@RequiredArgsConstructor
public class controller2 {

    private final CustomerRepo customerRepo;
    private final OrderRepository orderRepo;


    @GetMapping()
    public void foo(){
        // Create a new customer
        Customer customer = new Customer("John Doe");

        // Create orders and associate them with the customer
        Order order1 = new Order("Laptop");
//        Order order2 = new Order("Smartphone");

        // Set the customer to orders
        order1.setCustomer(customer);
//        order2.setCustomer(customer);

        // Add orders to customer
//        customer.setOrders(List.of(order1, order2));
        orderRepo.save(order1);
        // Save the customer (orders are saved automatically due to cascade)
//        customerRepo.save(customer);
    }





}