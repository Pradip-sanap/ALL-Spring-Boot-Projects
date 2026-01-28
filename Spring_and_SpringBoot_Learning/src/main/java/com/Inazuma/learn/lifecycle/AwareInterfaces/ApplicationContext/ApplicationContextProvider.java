package com.Inazuma.learn.lifecycle.AwareInterfaces.ApplicationContext;

// GET ACCESS TO ApplicationContext

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    // Static method to get ApplicationContext anywhere
    public static ApplicationContext getContext() {
        return context;
    }

    // Get any bean from anywhere in application
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
//        System.out.println(">>> ApplicationContextAware.setApplicationContext() called");
        context = applicationContext;
    }
}
