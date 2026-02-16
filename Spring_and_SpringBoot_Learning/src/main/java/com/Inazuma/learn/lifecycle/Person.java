package com.Inazuma.learn.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Person
            implements
        BeanNameAware,
        ApplicationContextAware
//        BeanPostProcessor
{

    private String name;
    private Integer age;

    //constructor
    public Person() {
        super();
        System.out.println("Contructor of Person called!!!");
    }

    //getter setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        System.out.println("Setting Person's Age");
        this.age = age;
    }



    // aware interfaces methods
    @Override
    public void setBeanName(String name) {
        name = "PradipsBean";
        System.out.println("BeanNameAware interface method called ->"+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println("ApplicationContextAware interface method called");
    }

    //BeanPostProcessor -> before init
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(">>> BEFORE Init: " + beanName + " [" + bean.getClass().getSimpleName() + "]");
//        return bean;  // Return the bean (or a proxy)
//    }

    //init method -> @PostConstruct
    @PostConstruct
    public void initMethod() {
        System.out.println("Inside init method");
    }

    //BeanPostProcessor -> after init
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(">>> AFTER Init: " + beanName + " [" + bean.getClass().getSimpleName() + "]");
//        return bean;
//    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("Inside destroy method");
    }



    //toString
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }


}
