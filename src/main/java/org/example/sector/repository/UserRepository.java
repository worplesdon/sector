package org.example.sector.repository;

import org.example.sector.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/** MongoDB repository for Users of the app */
public interface UserRepository extends MongoRepository<User, String> {}
