package com.mongo.learn.repository;

import com.mongo.learn.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
