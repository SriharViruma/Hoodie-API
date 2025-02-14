package com.learn.hoodiebackend.Service;

import com.learn.hoodiebackend.Model.User;
import com.learn.hoodiebackend.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> showAllUsers(){
        return userRepo.findAll();
    }

    public void UpdateUser(User user){
        userRepo.save(user);
    }

    public void DeleteById(long id){
        userRepo.deleteById(id);
    }


    public String login(String email,String password){
        List<User> userOptional = userRepo.findByEmail(email);
        System.out.println(userOptional);

        for( User user : userOptional)
            System.out.println(user.getPassword());
        System.out.println();

        if (!userOptional.isEmpty()){
            User user = userOptional.get(0);

            if (user.getPassword().equals(password)){
                return "200";
            }else
                return "500";
        }else
            return "404";

    }


    public void signing(User user) {
        userRepo.save(user);
    }
}
