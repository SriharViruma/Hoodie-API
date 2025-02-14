package com.learn.hoodiebackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "hoodie_images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoodieImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long hid;
    private String img_url;
}

