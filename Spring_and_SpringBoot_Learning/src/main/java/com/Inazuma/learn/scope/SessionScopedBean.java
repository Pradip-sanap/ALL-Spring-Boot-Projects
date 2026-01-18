package com.Inazuma.learn.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS) // or @Scope("session")
public class SessionScopedBean {
    private String sessionId;
    private String username;

    public SessionScopedBean() {
        this.sessionId = java.util.UUID.randomUUID().toString();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
