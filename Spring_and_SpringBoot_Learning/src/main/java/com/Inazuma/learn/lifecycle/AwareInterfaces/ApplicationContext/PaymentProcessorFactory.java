package com.Inazuma.learn.lifecycle.AwareInterfaces.ApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessorFactory implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }

    public PaymentProcessor getProcessor(String type) {
        switch (type) {
            case "CREDIT_CARD":
                return context.getBean(CreditCardProcessor.class);
            case "PAYPAL":
                return context.getBean(PayPalProcessor.class);
            case "CRYPTO":
                return context.getBean(CryptoProcessor.class);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}
interface PaymentProcessor {
    void processPayment(double amount);
}

@Component
class CreditCardProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        // Logic for processing credit card payment
        System.out.println("Processing credit card payment of amount: $" + amount);
        // Add more complex credit card payment logic here (validation, API calls, etc.)
    }
}

@Component
class PayPalProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        // Logic for processing PayPal payment
        System.out.println("Processing PayPal payment of amount: $" + amount);
        // Add more complex PayPal payment logic here (validation, API calls, etc.)
    }
}

@Component
class CryptoProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        // Logic for processing crypto payment
        System.out.println("Processing cryptocurrency payment of amount: $" + amount);
        // Add more complex cryptocurrency payment logic here (validation, API calls, etc.)
    }
}
