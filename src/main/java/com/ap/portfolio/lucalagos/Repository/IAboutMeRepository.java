package com.ap.portfolio.lucalagos.Repository;

import com.ap.portfolio.lucalagos.Entity.AboutMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAboutMeRepository extends JpaRepository<AboutMe, Integer> {

}
