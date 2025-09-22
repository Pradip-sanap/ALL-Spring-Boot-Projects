package com.aop.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

	public void transferMoney(String fromAccount, String toAccount, double amount) {
       
        System.out.println("Transferring " + amount + " from " + fromAccount + " to " + toAccount);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double getBalance(String accountId) {
        // Simulating balance check
        return 5000.0;
    }
}
