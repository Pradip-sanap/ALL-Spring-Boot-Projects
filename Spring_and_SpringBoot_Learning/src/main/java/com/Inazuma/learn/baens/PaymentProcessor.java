package com.Inazuma.learn.baens;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PaymentProcessor {

    public PaymentProcessor() {
        System.out.println("PaymentProcessor created");
    }

    public void process() {
        System.out.println("Processing payment...");
    }
}
