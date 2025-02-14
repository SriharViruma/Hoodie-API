package com.learn.hoodiebackend.Conttoller;


import com.learn.hoodiebackend.Model.User;
import com.learn.hoodiebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/showUsers")
    public List<User> showAllUsers(){
        return userService.showAllUsers();
    }

    @PutMapping("/EditUser")
    public void EditUser(@RequestBody User user){
        userService.UpdateUser(user);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public void DeleteUser(@PathVariable long id){
        userService.DeleteById(id);
    }

    //Login
    @PostMapping("/login")
    public ResponseEntity<Integer> Login(@RequestParam String email,@RequestParam String password){
        String res = userService.login(email,password);
        System.out.println("in controller"+email);
        if (res.equals("200")){
            return ResponseEntity.ok(200);
        }else
            return ResponseEntity.ok(404);
    }

    //sign in
    @PostMapping("/signing")
    public ResponseEntity<Integer> signing(@RequestBody User user){
       userService.signing(user);
       return ResponseEntity.ok(200);
    }
}
