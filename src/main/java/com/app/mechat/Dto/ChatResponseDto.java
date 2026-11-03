package com.app.mechat.Dto;

import lombok.Data;

import java.time.Instant;


public record ChatResponseDto(Long id, String message, Instant createdAt) {
}
