package com.Inazuma.learn.lifecycle.AwareInterfaces.BeanNameAware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;



@Service
public class LoggingService implements BeanNameAware {

    private String beanName;
    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void logOperation(String operation) {
        // Correct usage of placeholders with SLF4J
        logger.info("[Bean: {}] Performing operation: {}", beanName, operation);
    }


    public void processData() {
        logger.info("[{}] Processing data...", beanName);
        // Business logic
    }
}
