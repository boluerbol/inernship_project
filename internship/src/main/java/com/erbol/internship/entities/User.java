package com.erbol.internship.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity

@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "created_user", nullable = false, updatable = false)
    private LocalDateTime createdUser = LocalDateTime.now();

    @Column(name = "updated_user", nullable = false)
    private LocalDateTime updatedUser = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedUser = LocalDateTime.now();
    }
}
