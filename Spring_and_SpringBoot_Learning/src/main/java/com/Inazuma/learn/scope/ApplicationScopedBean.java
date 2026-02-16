package com.Inazuma.learn.scope;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Getter
@Component
@Scope(WebApplicationContext.SCOPE_APPLICATION) // or @Scope("application")
public class ApplicationScopedBean {
    private int totalVisits = 0;

    public synchronized void incrementVisits() {
        totalVisits++;
    }

}


