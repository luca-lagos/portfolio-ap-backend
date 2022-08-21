package com.ap.portfolio.lucalagos.Service;

import com.ap.portfolio.lucalagos.Entity.Experience;
import com.ap.portfolio.lucalagos.Repository.IExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienceService {
    @Autowired
    IExperienceRepository iExperienceRepository;

    public List<Experience> GetExperiences(){
        return iExperienceRepository.findAll();
    }

    public Optional<Experience> GetOneExperience(int id){
        return iExperienceRepository.findById(id);
    }

    public Optional<Experience> GetByJobName(String jobName){
        return iExperienceRepository.findByJobName(jobName);
    }

    public void AddExperience(Experience experience){
        iExperienceRepository.save(experience);
    }

    public void DeleteExperience(int id){
        iExperienceRepository.deleteById(id);
    }

    public boolean FindExperienceById(int id){
        return iExperienceRepository.existsById(id);
    }

    public boolean FindExperienceByJobName(String jobName){
        return iExperienceRepository.existsByJobName(jobName);
    }
}
