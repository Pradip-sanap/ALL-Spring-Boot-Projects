package com.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.model.User;
import com.jpa.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ApiResponse<T> {
    private String status;
    private T data;
}

@Data
@AllArgsConstructor
class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private Integer age;
}

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	private Map<Long, String> userDB = new HashMap<>();

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user, HttpServletRequest req){
		System.out.println(req.toString());
		System.out.println(">>> " + req.getMethod() + " " + req.getRequestURI() + "?" + req.getQueryString());
        req.getHeaderNames().asIterator().forEachRemaining(
            name -> System.out.println("Header " + name + ": " + req.getHeader(name))
        );
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	// 201 Created
    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody String name) {
        if (userDB.containsValue(name)) {
            throw new ConflictException("User with this name already exists"); // 409
        }
        long id = userDB.size() + 1;
        userDB.put(id, name);
        return ResponseEntity.ok("User created with id " + id);
    }
    
 // Delete user - 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id))
        	return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

   

    // Async Task - 202 Accepted
    @PostMapping("/async")
    public ResponseEntity<ApiResponse<String>> asyncTask() {
        userService.runAsyncTask();
        return ResponseEntity.accepted().body(new ApiResponse<>("success", "Task accepted"));
    }

    // 404 Not Found
    @GetMapping("/{id}")
    public ResponseEntity<String> getUser(@PathVariable Long id) {
        String user = userDB.get(id);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with id " + id); // 404
        }
        return ResponseEntity.ok(user);
    }

    // Simulate 401 Unauthorized
    @GetMapping("/secure")
    public ResponseEntity<String> secureEndpoint(@RequestHeader(value = "Authorization", required = false) String auth) {
        if (auth == null || !auth.equals("Bearer secret123")) {
            throw new UnauthorizedException("Invalid or missing token"); // 401
        }
        return ResponseEntity.ok("Secure data accessed");
    }

    // Simulate 403 Forbidden
    @GetMapping("/admin")
    public ResponseEntity<String> adminEndpoint(@RequestParam String role) {
        if (!"ADMIN".equals(role)) {
            throw new ForbiddenException("You don’t have permission"); // 403
        }
        return ResponseEntity.ok("Admin data accessed");
    }
}
