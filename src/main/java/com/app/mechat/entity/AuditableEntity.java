package com.app.mechat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.Instant;

@MappedSuperclass
@Data
public class AuditableEntity extends BaseEntity {
    @Column(name = "created_at")
    private Instant createdAt;

   public AuditableEntity(){
       this.createdAt = Instant.now();
   }
}
