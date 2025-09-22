package com.aop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.aop.service.AccountService;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}
	
	@Bean
    CommandLineRunner run(AccountService accountService) {
        return args -> {
            accountService.transferMoney("ACC123", "ACC456", 1000.0);
            System.out.println("Balance: " + accountService.getBalance("ACC123"));
        };
    }

}
