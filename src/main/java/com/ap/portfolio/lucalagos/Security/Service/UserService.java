package com.ap.portfolio.lucalagos.Security.Service;

import com.ap.portfolio.lucalagos.Security.Entity.UserCommon;
import com.ap.portfolio.lucalagos.Security.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("UserSecurityService")
@Transactional
public class UserService {
    @Autowired
    IUserRepository iUserRepository;

    public Optional<UserCommon> GetByUserName(String user_name){
        return iUserRepository.findByUserName(user_name);
    }

    public boolean ExistsByUserName(String user_name){
        return iUserRepository.existsByUserName(user_name);
    }

    public boolean ExistsByEmail(String email){
        return iUserRepository.existsByEmail(email);
    }

    public void SaveUser(UserCommon userCommon){
        iUserRepository.save(userCommon);
    }
}
