package com.harshit.user_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class UserRequest {

    @Positive(message = "Id must be positive")
    private int id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
