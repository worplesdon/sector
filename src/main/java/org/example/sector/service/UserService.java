package org.example.sector.service;

import java.util.List;
import org.example.sector.model.User;
import org.example.sector.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** Spring Service for Users of the app */
@Service
public class UserService {
  @Autowired private UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }
}
