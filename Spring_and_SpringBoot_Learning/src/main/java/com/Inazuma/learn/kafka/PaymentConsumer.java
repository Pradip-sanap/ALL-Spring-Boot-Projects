package com.Inazuma.learn.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {

    @KafkaListener(topics = "order-events", groupId = "payment-group")
    public void processPayment(OrderEvent event) {

        System.out.println("Received order: " + event);

        // Simulate payment logic
        if (event.getAmount() > 0) {
            System.out.println("Payment processed for order " + event.getOrderId());
        }
    }
}

