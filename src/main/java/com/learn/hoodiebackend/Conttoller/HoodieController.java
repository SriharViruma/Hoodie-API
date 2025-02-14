package com.learn.hoodiebackend.Conttoller;

import com.learn.hoodiebackend.Model.Hoodie;
import com.learn.hoodiebackend.Service.HoodieService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Data
class HoodieInput {
    private long id;

    private String name;
    private String description;
    private double price;
    private String size;
    private String color;
    private double offerPrice;
    private int stockQuantity;
    private String[] imgUrls;
}

@RestController
@RequestMapping("/hoodie")
public class HoodieController {
    @Autowired
    HoodieService hoodieService;

    @PostMapping("/Add")
    public void AddHoodie(@RequestBody HoodieInput hoodieInput){

        Hoodie hoodie = new Hoodie(
                hoodieInput.getId(),
                hoodieInput.getName(),
                hoodieInput.getDescription(),
                hoodieInput.getPrice(),
                hoodieInput.getOfferPrice(),
                hoodieInput.getSize(),
                hoodieInput.getColor(),
                hoodieInput.getStockQuantity(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        hoodieService.AddHoodie(hoodie, hoodieInput.getImgUrls());
    }

    @DeleteMapping("Delete/{id}")
    public void DeleteHoodie(@PathVariable long id){
        hoodieService.DeleteHoodie(id);
    }
}
