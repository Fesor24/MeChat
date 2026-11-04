package com.app.mechat.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record ChatRequestDto(
        @NotEmpty(message = "Message is required")
        String message) {

}
