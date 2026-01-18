package com.Inazuma.learn.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_APPLICATION) // or @Scope("application")
public class ApplicationScopedBean {
    private int totalVisits = 0;

    public synchronized void incrementVisits() {
        totalVisits++;
    }

    public int getTotalVisits() {
        return totalVisits;
    }
}
