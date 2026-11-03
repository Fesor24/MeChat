package com.app.mechat.repository;

import com.app.mechat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
    Optional<User> findByUserName(String userName);
}
