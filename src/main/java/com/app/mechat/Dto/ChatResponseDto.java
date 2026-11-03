package com.app.mechat.Dto;

import java.time.Instant;

public class ChatResponseDto {
    private Long id;
    private String message;
    private Instant createdAt;

    public ChatResponseDto(Long id, String message, Instant createdAt){
        this.id = id;
        this.message = message;
        this.createdAt = createdAt;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public void setCreatedAt(Instant createdAt){
        this.createdAt = createdAt;
    }

    public Instant getCreatedAt(){
        return this.createdAt;
    }
}
