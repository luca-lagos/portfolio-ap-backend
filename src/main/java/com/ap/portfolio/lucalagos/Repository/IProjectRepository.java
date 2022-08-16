package com.ap.portfolio.lucalagos.Repository;

import com.ap.portfolio.lucalagos.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Integer> {
    public Optional<Project> findByTitle(String title);
    public boolean existsByTitle(String title);
}
