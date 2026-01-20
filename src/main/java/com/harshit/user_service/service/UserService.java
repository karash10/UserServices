package com.harshit.user_service.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harshit.user_service.model.User;
import com.harshit.user_service.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(int id, String name) {
        User user = new User(id, name);
        userRepository.save(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
