package com.ap.portfolio.lucalagos.Service;

import com.ap.portfolio.lucalagos.Entity.Project;
import com.ap.portfolio.lucalagos.Repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService {
    @Autowired
    IProjectRepository iProjectRepository;

    public List<Project> GetProjects(){
        return iProjectRepository.findAll();
    }

    public Optional<Project> GetOneProject(int id){
        return iProjectRepository.findById(id);
    }

    public Optional<Project> GetByTitle(String title){
        return iProjectRepository.findByTitle(title);
    }

    public void AddProject(Project project){
        iProjectRepository.save(project);
    }

    public void DeleteProject(int id){
        iProjectRepository.deleteById(id);
    }

    public boolean FindProjectById(int id){
        return iProjectRepository.existsById(id);
    }

    public boolean FindProjectByTitle(String title){
        return iProjectRepository.existsByTitle(title);
    }
}
