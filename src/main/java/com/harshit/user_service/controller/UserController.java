package com.harshit.user_service.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
        @PathVariable int id,
        @RequestBody UserRequest request
    ){ return ResponseEntity.ok(userService.updateUser(id, request.getName()));}

    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable int id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
}

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest request) {
    User created = userService.createUser(
        request.getName()
    );

    

    
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
}


}