package com.app.mechat.dto;

public record RegisterUserRequestDto(
        String firstName,
        String lastName,
        String email,
        String password,
        String userName
) {
}
