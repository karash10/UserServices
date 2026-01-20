package com.harshit.user_service.dto;

import jakarta.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    public String getName() {
        return name;
    }
}
