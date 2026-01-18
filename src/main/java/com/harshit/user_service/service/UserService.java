package com.harshit.user_service.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harshit.user_service.model.User;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();


    public List<User> getAllUsers() {
        return List.of(
            new User(1, "Alice")
        );}

    public void addUser(User user) {
        users.add(user);
    }
}