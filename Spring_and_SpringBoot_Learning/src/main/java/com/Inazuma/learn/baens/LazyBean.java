package com.Inazuma.learn.baens;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyBean {
    public LazyBean() {
        System.out.println("LazyBean Initialized");
    }

    void print(){
        System.out.println("Hello from lazy bean");
    }
}
