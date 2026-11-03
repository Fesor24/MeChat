package com.app.mechat.Dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ChatResponseDto {
    private Long id;
    private String message;
    private Instant createdAt;

    public ChatResponseDto(Long id, String message, Instant createdAt){
        this.id = id;
        this.message = message;
        this.createdAt = createdAt;
    }
}
