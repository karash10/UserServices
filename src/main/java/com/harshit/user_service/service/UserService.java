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

    public User createUser( String name) {
        User user = new User(0, name);
        userRepository.save(user);
        return user;
    }
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }
    public User updateUser(int id, String name) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(name);
            userRepository.save(user);
        }
        return user;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
