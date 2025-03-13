package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.doa.UserRepository;
import com.demo.entities.User;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(FirstProjectApplication.class, args);
	
		UserRepository ur = context.getBean(UserRepository.class);
		
//		User u1 = new User();
//		u1.setName("ROhini");
//		u1.setCity("Kalyan");
//		u1.setStatus("SDE");
//		
//		User u2 = new User();
//		u2.setName("Laxman");
//		u2.setCity("Nashik");
//		u2.setStatus("DevOps");
//		
//		List<User> usersList = new ArrayList<>();
//		usersList.add(u1);
//		usersList.add(u2);
//		
//		List<User> resp = ur.saveAll(usersList);
//		
//		System.out.println("Result ->" + resp);
		
		
//		System.out.println(ur.count());;
		
		Optional<User> u3 = ur.findById(3);
		System.out.println(u3);
		System.out.println(u3.get());
		System.out.println(u3.get().getName());
		
		ur.delete(u3.get());
		
//		u3.get().setStatus("Cloud Engineer");
//		ur.save(u3.get());
		
		List<User> allUsers = ur.findAll();
//		System.out.println(allUsers);
		allUsers.forEach(user -> System.out.println(user));
//		System.out.println(allUsers.get());
//		System.out.println(allUsers.get().getName());
//		ur.delete(u3);
		
		System.out.println("Done!!");
		
	}

}
