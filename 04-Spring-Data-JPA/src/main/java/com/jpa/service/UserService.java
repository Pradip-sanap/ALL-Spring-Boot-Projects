package com.jpa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
 

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private Integer age;
}

@Service
public class UserService {

	private Map<Long, UserResponseDTO> userDB = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong(1);
    
	// Delete user
    public boolean deleteUser(Long id) {
        return userDB.remove(id) != null;
    }

    // Async processing example
    @Async
    public CompletableFuture<String> runAsyncTask() {
        try {
            Thread.sleep(5000); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Async task completed");
        return CompletableFuture.completedFuture("Task finished");
    }

  
}
