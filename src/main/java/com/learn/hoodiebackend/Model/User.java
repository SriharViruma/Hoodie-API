package com.learn.hoodiebackend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String address;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime UpdatedAt = LocalDateTime.now();


}
