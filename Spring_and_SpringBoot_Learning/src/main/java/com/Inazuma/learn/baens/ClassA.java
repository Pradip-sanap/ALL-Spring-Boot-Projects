package com.Inazuma.learn.baens;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("classB")
public class ClassA {
    public ClassA(){
        System.out.println("Class A called");
    }
}
