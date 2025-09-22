package com.cybage.entity;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import java.util.UUID;

@Component
//@Scope("prototype")
@Scope("prototype")
public class PrototypeBean {
    private final String id = UUID.randomUUID().toString();

    public PrototypeBean() {
        System.out.println("PrototypeBean instance created with ID: " + id);
    }

    public String getId() {
        return id;
    }
}

