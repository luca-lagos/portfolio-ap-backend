package com.ap.portfolio.lucalagos.Repository;

import com.ap.portfolio.lucalagos.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Integer> {
    public Optional<Experience> findByJobName(String jobName);
    public boolean existsByJobName(String jobName);
}
