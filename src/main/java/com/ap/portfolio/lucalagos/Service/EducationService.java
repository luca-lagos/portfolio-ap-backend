package com.ap.portfolio.lucalagos.Service;

import com.ap.portfolio.lucalagos.Entity.Education;
import com.ap.portfolio.lucalagos.Repository.IEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducationService {
    @Autowired
    IEducationRepository iEducationRepository;

    public List<Education> GetEducations(){
        return iEducationRepository.findAll();
    }

    public Optional<Education> GetOneEducation(int id){
        return iEducationRepository.findById(id);
    }

    public Optional<Education> GetByTitle(String title){
        return iEducationRepository.findByTitle(title);
    }

    public void AddEducation(Education education){
        iEducationRepository.save(education);
    }

    public void DeleteEducation(int id){
        iEducationRepository.deleteById(id);
    }

    public boolean FindEducationById(int id){
        return iEducationRepository.existsById(id);
    }

    public boolean FindEducationByTitle(String title){
        return iEducationRepository.existsByTitle(title);
    }
}
