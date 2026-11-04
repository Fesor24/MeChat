package com.app.mechat.dto;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequestDto(
        @NotEmpty(message = "Username is required")
        String userName,

        @NotEmpty(message = "Password is required")
        String password
) {
}
