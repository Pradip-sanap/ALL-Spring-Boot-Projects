package com.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    @Around("execution(* com.aop.service.*.*(..))")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("🔄 Opening Transaction for " + joinPoint.getSignature());
        try {
            Object result = joinPoint.proceed();
            System.out.println("✅ Committing Transaction for " + joinPoint.getSignature());
            return result;
        } catch (Exception e) {
            System.out.println("❌ Rolling back Transaction for " + joinPoint.getSignature());
            throw e;
        }
    }
}
