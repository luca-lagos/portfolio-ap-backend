package com.ap.portfolio.lucalagos.Service;

import com.ap.portfolio.lucalagos.Entity.User;
import com.ap.portfolio.lucalagos.Interface.IUserService;
import com.ap.portfolio.lucalagos.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService implements IUserService {
    @Autowired IUserRepository iUserRepository;

    @Override
    public List<User> GetUsers() {
        List<User> userList = iUserRepository.findAll();
        return userList;
    }

    @Override
    public void AddUser(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void DeleteUser(Long id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public User FindUser(Long id) {
        User user = iUserRepository.findById(id).orElse(null);
        return user;
    }
}
