package com.pradip.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradip.exception.UserNotFoundException;
import com.pradip.model.User;
import com.pradip.service.UserService;

@RestController
@RequestMapping("/api/users")
public class ApiUserController {

	private final UserService service;

	public ApiUserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	public List<User> all() {
		return service.list();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> get(@PathVariable Long id) {
		return service.find(id).map(ResponseEntity::ok).orElseThrow(() -> new UserNotFoundException(id));
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		User saved = service.createOrUpdate(user);
		return ResponseEntity.created(URI.create("/api/users/" + saved.getId())).body(saved);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
