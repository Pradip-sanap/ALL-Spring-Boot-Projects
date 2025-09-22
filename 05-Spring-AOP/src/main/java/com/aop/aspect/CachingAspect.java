package com.aop.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CachingAspect {

    private final Map<String, Object> cache = new HashMap<>();

    @Around("execution(* com.aop.service.AccountService.getBalance(..))")
    public Object cacheBalance(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toShortString() + Arrays.toString(joinPoint.getArgs());

        if (cache.containsKey(key)) {
            System.out.println("⚡ Returning cached result for " + key);
            return cache.get(key);
        }

        Object result = joinPoint.proceed();
        cache.put(key, result);
        System.out.println("💾 Caching result for " + key);
        return result;
    }
}