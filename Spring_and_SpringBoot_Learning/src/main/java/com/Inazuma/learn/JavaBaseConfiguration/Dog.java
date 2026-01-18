package com.Inazuma.learn.JavaBaseConfiguration;

public class Dog {
    String dogName;
    String dogGender;

    public Dog() {
    }

    public Dog(String dogName, String dogGender) {
        this.dogName = dogName;
        this.dogGender = dogGender;
    }

    public void print(){
        System.out.println("Dog bhowwww");
    }
}
