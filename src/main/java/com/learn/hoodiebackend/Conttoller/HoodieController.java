package com.learn.hoodiebackend.Conttoller;

import com.learn.hoodiebackend.Model.Hoodie;
import com.learn.hoodiebackend.Service.HoodieService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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
@CrossOrigin(origins = "http://localhost:5173")
public class HoodieController {
    @Autowired
    public HoodieController(HoodieService hoodieService){this.hoodieService =  hoodieService;}
    private final HoodieService hoodieService;

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

    @GetMapping("/showAllProducts")
    public List<Hoodie> showAllProducts(){
        return hoodieService.showAllProducts();
    }

    @DeleteMapping("Delete/{id}")
    public void DeleteHoodie(@PathVariable long id){
        hoodieService.DeleteHoodie(id);
    }
}
