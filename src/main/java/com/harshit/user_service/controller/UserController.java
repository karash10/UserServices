package com.harshit.user_service.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.user_service.dto.UserRequest;
import com.harshit.user_service.model.User;
import com.harshit.user_service.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest request) {
    User created = userService.createUser(
        request.getId(),
        request.getName()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
}


}