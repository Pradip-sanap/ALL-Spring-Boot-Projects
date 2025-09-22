package com.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// Pointcut: all methods in service package
    @Pointcut("execution(* com.aop.service.*.*(..))")
    public void serviceMethods() {}

    // Before advice
    @Before("serviceMethods()")
    public void logBefore() {
        System.out.println("👉 Method execution started...");
    }

    // After advice
    @After("serviceMethods()")
    public void logAfter() {
        System.out.println("✅ Method execution finished.");
    }

    // Around advice (for performance monitoring)
    @Around("serviceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // execute target method

        long end = System.currentTimeMillis();
        System.out.println("⏱ Execution time of " + joinPoint.getSignature() + " : " + (end - start) + " ms");

        return result;
    }
}
