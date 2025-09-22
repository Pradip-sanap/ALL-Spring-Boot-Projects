package com.pradip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pradip.model.User;
import com.pradip.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repo;

	//constructor
	public UserService(UserRepository repo) {
		this.repo = repo;
	}

	public User createOrUpdate(User user) {
		return repo.save(user);
	}

	public List<User> list() {
		return repo.findAll();
	}

	public Optional<User> find(Long id) {
		return repo.findById(id);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

}
