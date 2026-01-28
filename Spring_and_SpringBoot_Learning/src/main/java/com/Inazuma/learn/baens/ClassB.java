package com.Inazuma.learn.baens;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("classC")
public class ClassB {
    public ClassB(){
        System.out.println("Class B initialized");
    }
}
