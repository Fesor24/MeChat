package com.app.mechat.entity;

import jakarta.persistence.*;

import java.time.Instant;


@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String message;
    private Instant createdAt;

    public Long getId(){
        return this.id;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public Instant getCreatedAt(){
        return this.createdAt;
    }

    public static Chat create(String message){
        Chat chat = new Chat();
        chat.message = message;
        chat.createdAt = Instant.now();

        return chat;
    }
}
