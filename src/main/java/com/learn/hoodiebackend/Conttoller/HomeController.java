package com.learn.hoodiebackend.Conttoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String Welcome(){
        return "<h1>Welcome to Hoodie Api for sign in in use '/users/signing'</h1>";
    }
}
