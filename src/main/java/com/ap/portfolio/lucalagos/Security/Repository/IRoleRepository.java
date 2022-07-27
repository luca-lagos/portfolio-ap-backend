package com.ap.portfolio.lucalagos.Security.Repository;

import com.ap.portfolio.lucalagos.Security.Entity.Role;
import com.ap.portfolio.lucalagos.Security.Enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}
