package com.Inazuma.learn.JavaBaseConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig
{
    @Bean
    public Cat getCatObject(){
        return new Cat();
    }

    @Bean
    public Dog getDogObject(){
        return new Dog();
    }
}
