package com.Inazuma.learn.lifecycle.AwareInterfaces.EnvironmentAware;

import jakarta.annotation.PostConstruct;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// USE CASE: Profile-based configuration
@Component
public class DataSourceConfig implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void init() {
        String[] profiles = environment.getActiveProfiles();

        if (Arrays.asList(profiles).contains("prod")) {
            System.out.println("Production mode - using production database");
            // Configure production DB
        } else if (Arrays.asList(profiles).contains("dev")) {
            System.out.println("Development mode - using H2 database");
            // Configure H2 DB
        }
    }

    public String getDatabaseUrl() {
        return environment.getProperty("spring.datasource.url", "jdbc:h2:mem:testdb");
    }

    public boolean isFeatureEnabled(String featureName) {
        return environment.getProperty("features." + featureName, Boolean.class, false);
    }
}
