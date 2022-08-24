package com.ap.portfolio.lucalagos.Controller;

import com.ap.portfolio.lucalagos.DTO.ExperienceDTO;
import com.ap.portfolio.lucalagos.Entity.Experience;
import com.ap.portfolio.lucalagos.Security.Controller.Message;
import com.ap.portfolio.lucalagos.Service.ExperienceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("experience")
@CrossOrigin(origins = "https://frontend-port-ap-luca-lagos.web.app")
public class ExperienceController {
    @Autowired
    ExperienceService experienceService;

    @GetMapping("/list")
        public ResponseEntity<List<Experience>> GetExperiences() {
        List<Experience> experienceList = experienceService.GetExperiences();
        return new ResponseEntity(experienceList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> GetExperienceById(@PathVariable("id") int id){
        if(!experienceService.FindExperienceById(id)){
            return new ResponseEntity(new Message("La experiencia no existe"), HttpStatus.NOT_FOUND);
        }
        Experience experience = experienceService.GetOneExperience(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }

    /*@PreAuthorize("hasRole('ADMIN')")*/
    @PostMapping("/add")
    public ResponseEntity<?> CreateExperience(@RequestBody ExperienceDTO experienceDTO){
        if(StringUtils.isBlank(experienceDTO.getJobName())){
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(experienceService.FindExperienceByJobName(experienceDTO.getJobName())){
            return new ResponseEntity(new Message("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        Experience experience = new Experience(experienceDTO.getJobName(), experienceDTO.getJobDescription(), experienceDTO.getBusinessName(), experienceDTO.getBusinessImg(), experienceDTO.getLocation(), experienceDTO.getCountryLocation() , experienceDTO.getWorkTime(), experienceDTO.getWorkStart(), experienceDTO.getWorkEnd(), experienceDTO.isActualWork());
        experienceService.AddExperience(experience);
        return new ResponseEntity(new Message("La experiencia ha sido creada correctamente"), HttpStatus.OK);
    }

    /*@PreAuthorize("hasRole('ADMIN')")*/
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> UpdateExperience(@PathVariable("id") int id, @RequestBody ExperienceDTO experienceDTO){
        if(!experienceService.FindExperienceById(id)){
            return new ResponseEntity(new Message("La experiencia no existe"), HttpStatus.BAD_REQUEST);
        }
        if(experienceService.FindExperienceByJobName(experienceDTO.getJobName()) && experienceService.GetByJobName(experienceDTO.getJobName()).get().getId() != id){
            return new ResponseEntity(new Message("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(experienceDTO.getJobName())){
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Experience experience = experienceService.GetOneExperience(id).get();
        experience.setJobName(experienceDTO.getJobName());
        experience.setJobDescription(experienceDTO.getJobDescription());
        experience.setBusinessName(experienceDTO.getBusinessName());
        experience.setBusinessImg(experienceDTO.getBusinessImg());
        experience.setLocation(experienceDTO.getLocation());
        experience.setCountryLocation(experienceDTO.getCountryLocation());
        experience.setWorkTime(experienceDTO.getWorkTime());
        experience.setWorkStart(experienceDTO.getWorkStart());
        experience.setWorkEnd(experienceDTO.getWorkEnd());
        experience.setActualWork(experienceDTO.isActualWork());

        experienceService.AddExperience(experience);
        return new ResponseEntity(new Message("La experiencia ha sido actualizada correctamente"), HttpStatus.OK);
    }

    /*@PreAuthorize("hasRole('ADMIN')")*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteExperience(@PathVariable("id") int id){
        if(!experienceService.FindExperienceById(id)){
            return new ResponseEntity(new Message("La experiencia no existe"), HttpStatus.NOT_FOUND);
        }
        experienceService.DeleteExperience(id);
        return new ResponseEntity(new Message("La experiencia ha sido eliminada correctamente"), HttpStatus.OK);
    }
}
