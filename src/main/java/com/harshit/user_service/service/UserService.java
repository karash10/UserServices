package com.harshit.user_service.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harshit.user_service.model.User;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    public User createUser(int id, String name) {
        User user = new User(id, name);
        users.add(user);   // 🔥 THIS WAS MISSING
        return user;
    }

    public List<User> getAllUsers() {
        return List.copyOf(users);
    }
}
