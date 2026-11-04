package com.app.mechat.dto;

import java.time.Instant;


public record ChatResponseDto(Long id, String message, Instant createdAt) {
}
