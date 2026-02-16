package com.Inazuma.learn.scope;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class _BeanScopeController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private SingletonBean singletonBean;

    @Autowired
    private RequestScopedBean requestScopedBean;

    @Autowired
    private SessionScopedBean sessionScopedBean;

    @Autowired
    private ApplicationScopedBean applicationScopedBean;

    @GetMapping("/singleton")
    public String testSingleton() {
        SingletonBean bean1 = context.getBean(SingletonBean.class);
        SingletonBean bean2 = context.getBean(SingletonBean.class);

        bean1.increment();

        return "Bean1 counter: " + bean1.getCounter() +
                ", Bean2 counter: " + bean2.getCounter() +
                ", Same instance: " + (bean1 == bean2);
    }

    @GetMapping("/prototype")
    public String testPrototype() {
        PrototypeBean bean1 = context.getBean(PrototypeBean.class);
        System.out.println("bean1 "+ bean1.hashCode());
        PrototypeBean bean2 = context.getBean(PrototypeBean.class);
        System.out.println("bean2 "+ bean2.hashCode());

        bean1.increment();
        bean1.increment();
        bean2.increment();

        return "Bean1 counter: " + bean1.getCounter() +
                ", Bean2 counter: " + bean2.getCounter() +
                ", Same instance: " + (bean1 == bean2);
    }

    @GetMapping("/request")
    public String testRequest() {
        return "Request ID: " + requestScopedBean.getRequestId();
    }

    @GetMapping("/session")
    public String testSession(@RequestParam String username) {
        sessionScopedBean.setUsername(username);
        return "Session ID: " + sessionScopedBean.getSessionId() +
                ", Username: " + sessionScopedBean.getUsername();
        // Same session = same bean instance and data
    }

    @GetMapping("/application")
    public String testApplication() {
        applicationScopedBean.incrementVisits();
        return "Total visits: " + applicationScopedBean.getTotalVisits();
        // Shared across all users and sessions
    }
}
