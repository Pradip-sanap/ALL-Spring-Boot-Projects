package com.cybage.entity;

import org.springframework.stereotype.Component;

@Component
public  class Features {
    private boolean enableLogging;
    private int maxUsers;

    // Getters and Setters
    public boolean isEnableLogging() { return enableLogging; }
    public void setEnableLogging(boolean enableLogging) { this.enableLogging = enableLogging; }

    public int getMaxUsers() { return maxUsers; }
    public void setMaxUsers(int maxUsers) { this.maxUsers = maxUsers; }
}