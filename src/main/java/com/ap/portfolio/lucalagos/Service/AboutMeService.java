package com.ap.portfolio.lucalagos.Service;

import com.ap.portfolio.lucalagos.Entity.AboutMe;
import com.ap.portfolio.lucalagos.Repository.IAboutMeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
}
