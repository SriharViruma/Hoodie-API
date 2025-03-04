package com.learn.hoodiebackend.Conttoller;

import com.learn.hoodiebackend.Model.HoodieImages;
import com.learn.hoodiebackend.Model.Hoodie;
import com.learn.hoodiebackend.Model.HoodieInput;
import com.learn.hoodiebackend.Service.HoodieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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
    @GetMapping("/showImages")
    public List<HoodieImages> showImages(){
        return hoodieService.showimages();
    }
    @DeleteMapping("Delete/{id}")
    public void DeleteHoodie(@PathVariable long id){
        hoodieService.DeleteHoodie(id);
    }
}
