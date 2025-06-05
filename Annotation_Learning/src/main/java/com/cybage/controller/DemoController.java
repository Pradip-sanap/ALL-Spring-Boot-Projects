package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.entity.LazyBean;
import com.cybage.entity.PrototypeBean;
import com.cybage.service.DemoService;
import com.cybage.service.SampleService;

@RestController
public class DemoController {

	@Autowired
	@Qualifier("service_v2")
	DemoService demoService;
	
	@Autowired
	@Lazy
	private LazyBean lazyBean;
	
	private final SampleService appConfig;

    @Autowired
    public DemoController(SampleService appConfig) {
        this.appConfig = appConfig;
    }
    @GetMapping
    public void printConfig() {
        System.out.println("App Name: " + appConfig.getName());
        System.out.println("Version: " + appConfig.getVersion());
        System.out.println("Logging Enabled: " + appConfig.getFeatures().isEnableLogging());
        System.out.println("Max Users: " + appConfig.getFeatures().getMaxUsers());
        
        //------------------
        lazyBean.showMe();
       
    }
    
    @Autowired
    private PrototypeBean prototypeBean1;

    @Autowired
    private PrototypeBean prototypeBean2;
    
    @GetMapping("/scope")
    public void testPrototype() {
        System.out.println("PrototypeBean1 ID: " + prototypeBean1.getId());
        System.out.println("PrototypeBean2 ID: " + prototypeBean2.getId());
        
        System.out.println(prototypeBean1);
        System.out.println(prototypeBean2);
    }

}
