package com.learn.hoodiebackend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "hoodie_images")
public class HoodieImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long hid;
    private String img_url;

    public HoodieImages(long id, long hid, String img_url) {
        this.id = id;
        this.hid = hid;
        this.img_url = img_url;
    }
    public HoodieImages(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHid() {
        return hid;
    }

    public void setHid(long hid) {
        this.hid = hid;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}

