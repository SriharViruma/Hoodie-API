package com.learn.hoodiebackend.Conttoller;


import com.learn.hoodiebackend.Model.User;
import com.learn.hoodiebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<Integer> Login(@RequestBody Map<String,String> loginReq){
        String email = loginReq.get("email");
        String password = loginReq.get("password");
        String res = userService.login(email,password);
        System.out.println(email+":"+password);
        if (res.equals("200")){
            return ResponseEntity.ok(200);
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(404);
    }

    //sign in
    @PostMapping("/signing")
    public ResponseEntity<Integer> signing(@RequestBody User user){
       userService.signing(user);
       return ResponseEntity.ok(200);
    }
}
