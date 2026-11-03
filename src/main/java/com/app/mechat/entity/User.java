package com.app.mechat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User extends AuditableEntity{
    @Column(name = "first_name", length = 70)
    private String firstName;

    @Column(name = "last_name", length = 70)
    private String lastName;

    @Column(name = "user_name", length = 100)
    private String userName;

    @Column(name = "email", length = 70)
    private String email;

    @Column(name = "password", length = 200)
    private String password;

    public static User create(String firstName, String lastName,
                              String userName, String email,
                              String password){
        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        user.userName = userName;
        user.password = password;
        user.email = email;

        return user;
    }
}
