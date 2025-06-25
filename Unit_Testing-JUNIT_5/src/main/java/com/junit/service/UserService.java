package com.junit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junit.model.User;
import com.junit.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private  UserRepository userRepository;
	  
	@Autowired
	private EmailService emailService;

	public UserService(UserRepository userRepository, EmailService emailService) {
		this.userRepository = userRepository;
		this.emailService = emailService;
	}

	public User registerUser(User user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new IllegalArgumentException("Email already registered");
		}
		return userRepository.save(user);
	}

	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}

	public void sendEmail(String to, String subject, String body) {
		
		emailService.send(to, subject, body);
	}

}
 

