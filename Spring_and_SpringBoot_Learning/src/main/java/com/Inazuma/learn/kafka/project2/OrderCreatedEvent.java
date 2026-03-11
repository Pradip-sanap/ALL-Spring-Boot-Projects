package com.Inazuma.learn.kafka.project2;

public record OrderCreatedEvent(
        String orderId,
        String productCode,
        int quantity
) {}

