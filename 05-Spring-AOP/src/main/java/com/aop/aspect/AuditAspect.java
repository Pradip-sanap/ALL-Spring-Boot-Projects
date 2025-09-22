package com.aop.aspect;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

	@AfterReturning(pointcut = "execution(* com.aop.service.*.*(..))", returning = "result")
	public void logAudit(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        System.out.println("📝 AUDIT LOG: Method=" + methodName
                + ", Args=" + Arrays.toString(args)
                + ", Returned=" + result
                + ", Time=" + LocalDateTime.now()
                + ", User=" + getCurrentUser());
    }
	
	// Mock user from SecurityContext
    private String getCurrentUser() {
        return "john.doe"; // in real apps -> SecurityContextHolder.getContext().getAuthentication().getName()
    }
}
