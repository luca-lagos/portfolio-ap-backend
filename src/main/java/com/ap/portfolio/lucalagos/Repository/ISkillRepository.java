package com.ap.portfolio.lucalagos.Repository;

import com.ap.portfolio.lucalagos.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, Integer> {
    public Optional<Skill> findByName(String name);
    public boolean existsByName(String name);
}
