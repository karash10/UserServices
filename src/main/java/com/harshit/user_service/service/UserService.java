package com.harshit.user_service.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.harshit.user_service.exception.UserNotFoundException;
import com.harshit.user_service.model.User;
import com.harshit.user_service.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // CREATE USER (password is hashed here)
    public User createUser(String username, String rawPassword) {

        String hashedPassword = passwordEncoder.encode(rawPassword);

        User user = new User(username, hashedPassword);

        return userRepository.save(user);
    }

    // READ ALL USERS
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // READ USER BY ID
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // UPDATE USER (password optional – update only if needed)
    public User updateUser(int id, String newPassword) {

        User user = getUserById(id); // throws 404 if not found

        if (newPassword != null && !newPassword.isBlank()) {
            String hashedPassword = passwordEncoder.encode(newPassword);
            user.setPassword(hashedPassword);
        }

        return userRepository.save(user);
    }

    // DELETE USER
    public void deleteUser(int id) {

        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }

        userRepository.deleteById(id);
    }
}
