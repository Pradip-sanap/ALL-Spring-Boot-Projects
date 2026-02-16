package com.Inazuma.learn.scope;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Getter
@Component
@Scope(
        value = WebApplicationContext.SCOPE_REQUEST,
        proxyMode = ScopedProxyMode.TARGET_CLASS
) // or @Scope("request")
public class RequestScopedBean {
    private final String requestId;

    public RequestScopedBean() {
        this.requestId = java.util.UUID.randomUUID().toString();
    }

}
