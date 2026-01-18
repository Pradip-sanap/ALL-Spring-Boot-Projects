package com.Inazuma.learn.lifecycle.AwareInterfaces.ApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// USE CASE 1: Get beans dynamically at runtime
@Service
public class DynamicBeanService implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }

    public void processByStrategy(String strategyName) {
        // Get bean dynamically based on runtime value
        PaymentStrategy strategy = (PaymentStrategy) context.getBean(strategyName);
        strategy.process();
    }

    public List<String> getAllServiceBeans() {
        // Find all beans of specific type
        Map<String, PaymentStrategy> strategies = context.getBeansOfType(PaymentStrategy.class);
        return new ArrayList<>(strategies.keySet());
    }
}

interface PaymentStrategy{
    void process();
}

class Card implements PaymentStrategy{

    @Override
    public void process() {
        System.out.println("Card payment done.");
    }
}

class UPI implements  PaymentStrategy {

    @Override
    public void process() {
        System.out.println("UPI payment done.");
    }
}
class CRYPTO implements  PaymentStrategy{

    @Override
    public void process() {
        System.out.println("Crypto payment done.");
    }
}