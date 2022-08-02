package com.ap.portfolio.lucalagos.Controller;

import java.util.List;
import com.ap.portfolio.lucalagos.Entity.User;
import com.ap.portfolio.lucalagos.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping("/users/list")
    public List<User> GetUsers(){
        return iUserService.GetUsers();
    }


    @GetMapping("/users/my-profile")
    public User FindUser(){
        return iUserService.FindUser((long)1);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/users/add")
    public String CreateUser(@RequestBody User user){
        iUserService.AddUser(user);
        return "El usuario ha sido creado correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/delete/{id}")
    public String DeleteUser(@PathVariable Long id){
        iUserService.DeleteUser(id);
        return "El usuario ha sido eliminado correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/users/edit/{id}")
    public User UpdateUser(@PathVariable Long id,
                             @RequestParam("name") String new_name,
                             @RequestParam("lastname") String new_lastname, @RequestParam("profile_img") String new_profile_img){
        User user = iUserService.FindUser(id);
        user.setName(new_name);
        user.setLastname(new_lastname);
        user.setProfile_img(new_profile_img);
        iUserService.AddUser(user);
        return user;
    }
}
