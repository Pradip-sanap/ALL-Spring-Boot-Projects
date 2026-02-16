package com.Inazuma.learn.baens;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.security.Provider;

@Service
public class OrderService {


    private final ObjectProvider<PaymentProcessor> provider;

    @Autowired
    @Lazy
    private LazyBean lazyBean;

    public OrderService(ObjectProvider<PaymentProcessor> provider){
        this.provider = provider;
        System.out.println("OrderService contructor called");
    }

//    @Lookup
//    public PaymentProcessor getPaymentProcessor() {
//        return null; // Spring overrides this
//    }

    public void check(){
        System.out.println("Checking lazy");
        lazyBean.print();
    }

    public void placeOrder() {
//        PaymentProcessor processor = getPaymentProcessor();
        PaymentProcessor processor = provider.getObject();
        processor.process();

    }
}

