package com.learn.hoodiebackend.Model;

public class HoodieInput {
        private long id;
        private String name;
        private String description;
        private double price;
        private String size;
        private String color;
        private double offerPrice;
        private int stockQuantity;
        private String[] imgUrls;

        public long getId() {return id;}
        public String getName() {return name;}
        public String getDescription() {return description;}
        public double getPrice() {return price;}
        public String getSize() {return size;}
        public String getColor() {return color;}
        public double getOfferPrice() {return offerPrice;}
        public int getStockQuantity() {return stockQuantity;}
        public String[] getImgUrls() {return imgUrls;}



}

