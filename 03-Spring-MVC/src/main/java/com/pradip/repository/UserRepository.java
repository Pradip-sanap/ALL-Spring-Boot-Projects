package com.pradip.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.pradip.model.User;

@Repository
public class UserRepository {

	private final Map<Long, User> store = new ConcurrentHashMap<>();
	private final AtomicLong idGen = new AtomicLong(100);

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(idGen.incrementAndGet());
		}
		store.put(user.getId(), user);
		return user;
	}

	public List<User> findAll() {
		return new ArrayList<>(store.values());
	}

	public Optional<User> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}

	public void deleteById(Long id) {
		store.remove(id);
	}
}
