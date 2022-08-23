package com.ap.portfolio.lucalagos.Service;

import com.ap.portfolio.lucalagos.Entity.AboutMe;
import com.ap.portfolio.lucalagos.Repository.IAboutMeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AboutMeService {
    @Autowired
    IAboutMeRepository iAboutMeRepository;

    public List<AboutMe> GetAboutMes(){
        return iAboutMeRepository.findAll();
    }

    public Optional<AboutMe> GetOneAboutMe(int id){
        return iAboutMeRepository.findById(id);
    }

    public Optional<AboutMe> GetByDescription(String description){
        return iAboutMeRepository.findByDescription(description);
    }

    public void AddAboutMe(AboutMe aboutMe){
        iAboutMeRepository.save(aboutMe);
    }

    public void DeleteAboutMe(int id){
        iAboutMeRepository.deleteById(id);
    }

    public boolean FindAboutMeById(int id){
        return iAboutMeRepository.existsById(id);
    }

    public boolean FindAboutMeByDescription(String description){
        return iAboutMeRepository.existsByDescription(description);
    }
}
