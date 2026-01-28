package com.Inazuma.learn.controller;


import com.Inazuma.learn.JavaBaseConfiguration.Cat;
import com.Inazuma.learn.JavaBaseConfiguration.Dog;
import com.Inazuma.learn.JavaBaseConfiguration.MyConfig;
import com.Inazuma.learn.model.Address;
import com.Inazuma.learn.model.Database;
import com.Inazuma.learn.model.Order;
import com.Inazuma.learn.service.ReportService;
import com.Inazuma.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;
    private final Address address;
    private final Order order;
    private final Database database;
    private final Dog dog;
    private final Cat cat;
    @Autowired
    private ReportService reportService;
    @Autowired
    private Environment environment;


    @Autowired
    private List<Address> allAddress;

    @Autowired
    private Map<String, Address> addressMap; // ✅ Bean name as key, bean as value

    public UserController(
            UserService userService,
            @Qualifier("temporararyAddress") Address address,
            Order order,
            Database database,
            Dog dog,
            Cat cat){
        this.userService = userService;
        this.address = address;
        this.order = order;
        this.database = database;
        this.dog = dog;
        this.cat = cat;
//        this.reportService = reportService;
    }

    @GetMapping("/hello")
    public void hello() {
        address.print();
        userService.print();

        System.out.println(allAddress);
        System.out.println(addressMap);
    }

    @GetMapping("/order")
    public List<Object> getValues(@Value("${order.sku}") int sku){
        System.out.println(sku);
        List<Object> list = new ArrayList<>();
        list.add(order.getName());
        list.add(order.getVersion());
        list.add(order.getTimeout());
        list.add(order.getPrice());
        list.add(sku);
        list.add(order.getStock());
        list.add(order.getSameSkuNumber());
        return list;
    }

    @GetMapping("/database")
    public void getdb(){
        System.out.println(database.getUrl());
        System.out.println(database.getPassword());
        System.out.println(database.getUsername());
        System.out.println(database.getPool());
        System.out.println(database.getServers());
        System.out.println(database.getRoles());
    }

    @GetMapping("/config")
    public void getConfig(){
        cat.print();
        dog.print();
    }

    @GetMapping("/test")
    public String test() {
//        environment.getActiveProfiles();

        return "OK";
    }
}
