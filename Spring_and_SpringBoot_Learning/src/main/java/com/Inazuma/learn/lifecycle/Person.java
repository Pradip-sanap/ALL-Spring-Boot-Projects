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
//            implements
//        BeanNameAware,
//        ApplicationContextAware,
//        BeanPostProcessor
{

    private String name;
    private Integer age;

    public Person() {
        super();
        System.out.println("Contructor of Person called!!!");
    }

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

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    //------------------------------------------------------
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(">>> BEFORE Init: " + beanName + " [" + bean.getClass().getSimpleName() + "]");
//        return bean;  // Return the bean (or a proxy)
//    }

//    @PostConstruct
//    public void initMethod() {
//        System.out.println("Inside init method");
//    }

//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(">>> AFTER Init: " + beanName + " [" + bean.getClass().getSimpleName() + "]");
//        return bean;
//    }

//    @PreDestroy
//    public void destroyMethod() {
//        System.out.println("Inside destroy method");
//    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//
//    }

//    @Override
//    public void setBeanName(String name) {
//        name = "PradipsBean";
//        System.out.println(name);
//    }
}
