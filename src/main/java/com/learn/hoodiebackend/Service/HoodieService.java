package com.learn.hoodiebackend.Service;

import com.learn.hoodiebackend.Model.Hoodie;
import com.learn.hoodiebackend.Model.HoodieImages;
import com.learn.hoodiebackend.Repo.HoodieImagesRepo;
import com.learn.hoodiebackend.Repo.HoodieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoodieService {

    @Autowired
    private HoodieRepo hoodieRepo;

    @Autowired
    private HoodieImagesRepo hoodieImagesRepo;

    public void AddHoodie(Hoodie hoodie, String[] imgUrls ){
        hoodieRepo.save(hoodie);
        long hid = hoodieRepo.findMaxId();

        for( String url: imgUrls) {
            HoodieImages hoodieImages = new HoodieImages( 0, hid, url);
            hoodieImagesRepo.save(hoodieImages);
        }
    }

    public List<Hoodie> showAllProducts(){
        return hoodieRepo.findAll();
    }

    public void DeleteHoodie(long id) {
        hoodieRepo.deleteById(id);
    }
}
