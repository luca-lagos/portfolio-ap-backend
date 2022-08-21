package com.ap.portfolio.lucalagos.Service;

import com.ap.portfolio.lucalagos.Entity.User;
import com.ap.portfolio.lucalagos.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("UserService")
@Transactional
public class UserService {
    @Autowired IUserRepository iUserRepository;

    public List<User> GetUsers() {
        return iUserRepository.findAll();
    }

    public Optional<User> GetOneUser(int id){
        return iUserRepository.findById(id);
    }

    public void AddUser(User user) {
        iUserRepository.save(user);
    }

    public void DeleteUser(int id) {
        iUserRepository.deleteById(id);
    }

    public boolean FindUserById(int id) {
        return iUserRepository.existsById(id);
    }
}
