package com.ap.portfolio.lucalagos.Interface;

import com.ap.portfolio.lucalagos.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    //Read all users
    public List<User> GetUsers();
    //Add new user
    public void AddUser(User user);
    //Delete user
    public void DeleteUser(Long id);
    //Search user
    public User FindUser(Long id);
}
