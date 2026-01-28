package com.Inazuma.learn.lifecycle.AwareInterfaces.EnvironmentAware;

// ACCESS APPLICATION PROPERTIES AND PROFILES

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EnvironmentAwareDemo implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
//        System.out.println(">>> EnvironmentAware.setEnvironment() called");
        this.environment = environment;
    }

    public void printEnvironmentInfo() {
        // Get active profiles
        String[] profiles = environment.getActiveProfiles();
        System.out.println("Active profiles: " + Arrays.toString(profiles));

        // Get properties
        String appName = environment.getProperty("spring.application.name");
        String port = environment.getProperty("server.port");

        System.out.println("App name: " + appName);
        System.out.println("Port: " + port);
    }
}
