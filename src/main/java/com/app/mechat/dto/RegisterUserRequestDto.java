package com.app.mechat.dto;

import jakarta.validation.constraints.*;

public record RegisterUserRequestDto(
        @NotEmpty(message = "First name is required")
        @Size(max = 70, message = "First name cannot exceed 70 characters")
        String firstName,

        @NotEmpty(message = "Last name is required")
        @Size(max = 70, message = "Last name cannot exceed 70 characters")
        String lastName,

        @NotEmpty(message = "Email is required")
        @Email(message = "Invalid email")
        String email,

        @NotEmpty(message = "Password is required")
        String password,

        @NotEmpty(message = "Username is required")
        @Size(max = 70, message = "Username cannot exceed 70 characters")
        String userName
) {
}
