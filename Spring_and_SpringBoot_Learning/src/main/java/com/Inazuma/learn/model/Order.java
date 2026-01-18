package com.Inazuma.learn.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class Order {

    @Value("${app.name}")
    private String name;

    @Value("${app.version}")
    private float version;

    @Value("${app.timeout}")
    private int timeout;

    @Value("${app.price:88}")
    private int price;

    @Value("#{10 + 5}")
    private int stock;

    @Value("#{10 == 10}")
    private String sameSkuNumber;

    @Value("${app.servers}")
    private List<String> servers;
}
