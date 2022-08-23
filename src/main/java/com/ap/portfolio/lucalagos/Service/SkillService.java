package com.ap.portfolio.lucalagos.Service;

import com.ap.portfolio.lucalagos.Entity.Skill;
import com.ap.portfolio.lucalagos.Repository.ISkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillService {
    @Autowired
    ISkillRepository iSkillRepository;

    public List<Skill> GetSkills(){
        return iSkillRepository.findAll();
    }

    public Optional<Skill> GetOneSkill(int id){
        return iSkillRepository.findById(id);
    }

    public Optional<Skill> GetByName(String name){
        return iSkillRepository.findByName(name);
    }

    public void AddSkill(Skill skill){
        iSkillRepository.save(skill);
    }

    public void DeleteSkill(int id){
        iSkillRepository.deleteById(id);
    }

    public boolean FindSkillById(int id){
        return iSkillRepository.existsById(id);
    }

    public boolean FindSkillByName(String name){
        return iSkillRepository.existsByName(name);
    }
}
