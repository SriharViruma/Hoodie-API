package com.learn.hoodiebackend.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "hoodies")
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

    public Hoodie(long id, String name, String description, double price, double offer_price, String size, String color, int stockQuantity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.offer_price = offer_price;
        this.size = size;
        this.color = color;
        this.stockQuantity = stockQuantity;
        this.createdAt = createdAt;
        UpdatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Hoodie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", offer_price=" + offer_price +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", createdAt=" + createdAt +
                ", UpdatedAt=" + UpdatedAt +
                '}';
    }

    public Hoodie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOffer_price() {
        return offer_price;
    }

    public void setOffer_price(double offer_price) {
        this.offer_price = offer_price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }
}

