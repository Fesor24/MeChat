package com.app.mechat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.Instant;

@MappedSuperclass
public class AuditableEntity extends BaseEntity {
    @Column(name = "created_at")
    private Instant createdAt;

    public void setCreatedAt(Instant createdAt){
        this.createdAt = createdAt;
    }

    public Instant getCreatedAt(){
        return this.createdAt;
    }
}
