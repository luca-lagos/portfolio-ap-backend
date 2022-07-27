package com.ap.portfolio.lucalagos.Security.Repository;

import com.ap.portfolio.lucalagos.Security.Entity.UserCommon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("UserSecurityRepository")
public interface IUserRepository extends JpaRepository<UserCommon, Integer> {
    Optional<UserCommon> findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
