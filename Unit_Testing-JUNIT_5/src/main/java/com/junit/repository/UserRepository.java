package com.junit.repository;
 
 

import java.util.Optional;

import com.junit.model.User;

public interface UserRepository {
    Optional<User> findById(Long id);
    User save(User user);
    boolean existsByEmail(String email);
    
    
}

 