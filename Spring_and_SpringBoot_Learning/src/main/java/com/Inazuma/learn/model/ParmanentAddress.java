package com.Inazuma.learn.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class ParmanentAddress implements Address{
    public ParmanentAddress(){
        System.out.println("ParmanentAdress contructor");
    }

    public void print(){
        System.out.println("Parmenent");
    }
}
