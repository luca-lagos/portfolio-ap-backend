package com.ap.portfolio.lucalagos.Repository;

import com.ap.portfolio.lucalagos.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEducationRepository extends JpaRepository<Education, Integer> {
    public Optional<Education> findByTitle(String title);
    public boolean existsByTitle(String title);
}
