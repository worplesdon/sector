package org.example.sector.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.example.sector.model.User;

/** MongoDB repository for Users of the app */
public interface UserRepository extends MongoRepository<User, String> {
}
