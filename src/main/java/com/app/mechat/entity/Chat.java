package com.app.mechat.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "chats")
@Data
public class Chat extends AuditableEntity{
    @Column(nullable = false, length = 150)
    private String message;

    public static Chat create(String message){
        Chat chat = new Chat();
        chat.message = message;
        chat.setCreatedAt(Instant.now());

        return chat;
    }
}
