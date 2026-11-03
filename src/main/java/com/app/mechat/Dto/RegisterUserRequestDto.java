package com.app.mechat.Dto;

public record RegisterUserRequestDto(
        String firstName,
        String lastName,
        String email,
        String password,
        String userName
) {
}
