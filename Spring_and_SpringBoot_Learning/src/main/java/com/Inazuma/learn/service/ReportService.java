package com.Inazuma.learn.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Lazy
public class ReportService {

    public ReportService() {
        System.out.println("ReportService connstructor called");
    }
}

