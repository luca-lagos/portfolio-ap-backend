package com.ap.portfolio.lucalagos.Security.Service;

import com.ap.portfolio.lucalagos.Security.Entity.UserCommon;
import com.ap.portfolio.lucalagos.Security.Entity.UserMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
        UserCommon userCommon = userService.GetByUserName(user_name).get();
        return UserMain.build(userCommon);
    }
}
