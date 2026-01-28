package com.Inazuma.learn.lifecycle.AwareInterfaces.BeanNameAware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class BeanNameAwareDemo implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(String name) {
//        System.out.println(">>> BeanNameAware.setBeanName() called with: " + name);
        this.beanName = name;
    }

    public void printBeanName() {
        System.out.println("My bean name is: " + beanName);
    }
}
