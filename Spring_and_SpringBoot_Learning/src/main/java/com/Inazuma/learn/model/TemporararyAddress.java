package com.Inazuma.learn.model;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Lazy
public class TemporararyAddress implements Address{
    public TemporararyAddress(){
        System.out.println("TemporararyAddress contructor");
    }

    public void print(){
        System.out.println("TemporararyAddress");
    }
}