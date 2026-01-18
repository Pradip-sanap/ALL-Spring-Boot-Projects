package com.Inazuma.learn.JavaBaseConfiguration;

import org.springframework.stereotype.Component;

@Component
public class Cat {
    String catname;
    String catGender;

    public Cat() {
    }

    public Cat(String catname, String catGender) {
        this.catname = catname;
        this.catGender = catGender;
    }

    public void print(){
        System.out.println("Cat meow");
    }
}
