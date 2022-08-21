package com.ap.portfolio.lucalagos.Controller;

import java.util.List;

import com.ap.portfolio.lucalagos.DTO.UserDTO;
import com.ap.portfolio.lucalagos.Entity.User;
import com.ap.portfolio.lucalagos.Security.Controller.Message;
import com.ap.portfolio.lucalagos.Service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> GetUsers(){
        List<User> userList = userService.GetUsers();
        return new ResponseEntity(userList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<User> GetUserById(@PathVariable("id") int id){
        if(!userService.FindUserById(id)){
            return new ResponseEntity(new Message("El usuario no existe"), HttpStatus.NOT_FOUND);
        }
        User user = userService.GetOneUser(id).get();
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> CreateUser(@RequestBody UserDTO userDTO){
        User user = new User(userDTO.getName(), userDTO.getLastname(), userDTO.getProfession(), userDTO.getLocation(), userDTO.getCountryLocation(), userDTO.getUserProfileImg(), userDTO.getUserBackgroundImg());
        userService.AddUser(user);
        return new ResponseEntity(new Message("Los datos del usuario han sido creados correctamente"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> UpdateUser(@PathVariable("id") int id, @RequestBody UserDTO userDTO){
        if(!userService.FindUserById(id)) {
            return new ResponseEntity(new Message("Los datos del usuario no existen"), HttpStatus.NOT_FOUND);
        }
        User user = userService.GetOneUser(id).get();
        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setProfession(userDTO.getProfession());
        user.setLocation(userDTO.getLocation());
        user.setCountryLocation(userDTO.getCountryLocation());
        user.setUserProfileImg(userDTO.getUserProfileImg());
        user.setUserBackgroundImg(userDTO.getUserBackgroundImg());

        userService.AddUser(user);
        return new ResponseEntity(new Message("Los datos del usuario han sido actualizados correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable("id") int id){
        if(!userService.FindUserById(id)){
            return new ResponseEntity(new Message("Los datos del usuario no existen"), HttpStatus.NOT_FOUND);
        }
        userService.DeleteUser(id);
        return new ResponseEntity(new Message("Los datos del usuario han sido eliminados correctamente"), HttpStatus.OK);
    }

    /*@GetMapping("/users/my-profile")
    public User FindUser(){
        return iUserService.FindUser((long)1);
    }*/

    /*@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/users/add")
    public String CreateUser(@RequestBody User user){
        iUserService.AddUser(user);
        return "El usuario ha sido creado correctamente";
    }*/

    /*@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/delete/{id}")
    public String DeleteUser(@PathVariable Long id){
        iUserService.DeleteUser(id);
        return "El usuario ha sido eliminado correctamente";
    }*/

    /*@PreAuthorize("hasRole('ADMIN')")
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
    }*/
}
