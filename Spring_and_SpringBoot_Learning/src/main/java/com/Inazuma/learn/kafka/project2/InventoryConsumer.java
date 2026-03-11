package com.Inazuma.learn.kafka.project2;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumer {

    @KafkaListener(topics = "order-created", groupId = "inventory-group")
    public void consume(OrderCreatedEvent event) {
        System.out.println("Inventory updated for product: " + event.productCode());
    }
}

