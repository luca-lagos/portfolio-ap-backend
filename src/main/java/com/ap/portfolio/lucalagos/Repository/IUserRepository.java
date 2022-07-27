package com.ap.portfolio.lucalagos.Repository;

import com.ap.portfolio.lucalagos.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface IUserRepository extends JpaRepository<User, Long> {

}
