package com.cybage.entity;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class DatabaseConnection {

    private String connection;

    public DatabaseConnection() {
        System.out.println("Constructor: DatabaseConnection instance created.");
    }

    @PostConstruct
    public void initialize() {
        connection = "Connected to Database";
        System.out.println("PostConstruct: " + connection);
    }

    @PreDestroy
    public void cleanup() {
        connection = null;
        System.out.println("PreDestroy: Database connection closed.");
    }
}

