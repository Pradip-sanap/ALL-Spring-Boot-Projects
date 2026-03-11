package com.Inazuma.learn.kafka;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public String createOrder() {

        OrderEvent event = new OrderEvent(
                "ORD-101",
                "USER-1",
                2500.00,
                "CREATED"
        );

        orderProducer.sendOrderEvent(event);
        return "Order placed successfully";
    }
}
