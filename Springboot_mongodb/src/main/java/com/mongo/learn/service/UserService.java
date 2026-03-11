package com.mongo.learn.service;

import com.mongo.learn.model.User;
import com.mongo.learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Save a user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Find all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Find user by ID
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    // Delete user by ID
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
