package com.ap.portfolio.lucalagos.Controller;

import com.ap.portfolio.lucalagos.DTO.EducationDTO;
import com.ap.portfolio.lucalagos.Entity.Education;
import com.ap.portfolio.lucalagos.Security.Controller.Message;
import com.ap.portfolio.lucalagos.Service.EducationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("education")
@CrossOrigin(origins = "http://localhost:4200")
public class EducationController {
    @Autowired
    EducationService educationService;

    @GetMapping("/list")
    public ResponseEntity<List<Education>> GetEducations(){
        List<Education> educationList = educationService.GetEducations();
        return new ResponseEntity(educationList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> GetEducationById(@PathVariable("id") int id){
        if(!educationService.FindEducationById(id)){
            return new ResponseEntity(new Message("La educacion no existe"), HttpStatus.NOT_FOUND);
        }
        Education education = educationService.GetOneEducation(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> CreateEducation(@RequestBody EducationDTO educationDTO){
        if(StringUtils.isBlank(educationDTO.getTitle())){
            return new ResponseEntity(new Message("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(educationService.FindEducationByTitle(educationDTO.getTitle())){
            return new ResponseEntity(new Message("La educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        Education education = new Education(educationDTO.getTitle(), educationDTO.getInstituteName(), educationDTO.getInstituteImg(), educationDTO.getEduStart(), educationDTO.getEduEnd(), educationDTO.isActualEdu());
        educationService.AddEducation(education);
        return new ResponseEntity(new Message("La educacion ha sido creada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> UpdateEducation(@PathVariable("id") int id, @RequestBody EducationDTO educationDTO){
        if(!educationService.FindEducationById(id)){
            return new ResponseEntity(new Message("La educacion no existe"), HttpStatus.NOT_FOUND);
        }
        if(educationService.FindEducationByTitle(educationDTO.getTitle()) && educationService.GetByTitle(educationDTO.getTitle()).get().getId() != id){
            return new ResponseEntity(new Message("La educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(educationDTO.getTitle())){
            return new ResponseEntity(new Message("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Education education = educationService.GetOneEducation(id).get();
        education.setTitle(educationDTO.getTitle());
        education.setInstituteName(educationDTO.getInstituteName());
        education.setInstituteImg(educationDTO.getInstituteImg());
        education.setEduStart(educationDTO.getEduStart());
        education.setEduEnd(educationDTO.getEduEnd());
        education.setActualEdu(educationDTO.isActualEdu());

        educationService.AddEducation(education);
        return new ResponseEntity(new Message("La educacion ha sido actualizada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteEducation(@PathVariable("id") int id){
        if(!educationService.FindEducationById(id)){
            return new ResponseEntity(new Message("La educacion no existe"), HttpStatus.NOT_FOUND);
        }
        educationService.DeleteEducation(id);
        return new ResponseEntity(new Message("La educacion ha sido eliminada correctamente"), HttpStatus.OK);
    }
}
