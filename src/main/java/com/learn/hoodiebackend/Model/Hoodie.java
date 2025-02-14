package com.learn.hoodiebackend.Model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "hoodies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hoodie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private double price;
    private double offer_price;
    private String size;
    private String color;
    private int stockQuantity;

    private LocalDateTime createdAt;

    private LocalDateTime UpdatedAt;

    }

