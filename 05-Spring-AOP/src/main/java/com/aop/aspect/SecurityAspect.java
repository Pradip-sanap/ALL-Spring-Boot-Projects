package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

	@Before("execution(* com.aop.service.AccountService.transferMoney(..))")
    public void checkPermission(JoinPoint joinPoint) {
        String user = getCurrentUser();
//        if (!hasPermission(user)) {
//            throw new SecurityException("❌ Access denied for user: " + user);
//        }
        System.out.println("🔐 Security Check Passed for user: " + user);
    }

    private String getCurrentUser() {
        return "john.doe"; // in real apps -> from SecurityContextHolder
    }

    private boolean hasPermission(String user) {
        return "admin".equals(user); // mock check
    }
}
