package com.Inazuma.learn.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryConsumer {

    @KafkaListener(topics = "order-events", groupId = "inventory-group")
    public void updateInventory(OrderEvent event) {

        System.out.println("Updating inventory for order " + event.getOrderId());
    }
}

