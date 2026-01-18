package com.Inazuma.learn.lifecycle.AwareInterfaces.BeanFactoryAware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

// GET ACCESS TO BeanFactory (lower level than ApplicationContext)
@Component
public class BeanFactoryAwareDemo implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(">>> BeanFactoryAware.setBeanFactory() called");
        this.beanFactory = beanFactory;
    }

    public void checkBeanExists(String beanName) {
        boolean exists = beanFactory.containsBean(beanName);
        System.out.println("Bean '" + beanName + "' exists: " + exists);
    }

    public boolean isSingleton(String beanName) {
        return beanFactory.isSingleton(beanName);
    }

    public boolean isPrototype(String beanName) {
        return beanFactory.isPrototype(beanName);
    }
}
