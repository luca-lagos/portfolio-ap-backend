package com.ap.portfolio.lucalagos.Security.Service;

import com.ap.portfolio.lucalagos.Security.Entity.Role;
import com.ap.portfolio.lucalagos.Security.Enums.RoleName;
import com.ap.portfolio.lucalagos.Security.Repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@Transactional
public class RoleService {
    @Autowired
    IRoleRepository iRoleRepository;

    public Optional<Role> GetByRoleName(RoleName roleName){
        return iRoleRepository.findByRoleName(roleName);
    }

    public void SaveRole(Role role){
        iRoleRepository.save(role);
    }
}
