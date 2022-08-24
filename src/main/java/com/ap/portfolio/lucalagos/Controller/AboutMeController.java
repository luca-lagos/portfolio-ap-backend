package com.ap.portfolio.lucalagos.Controller;

import com.ap.portfolio.lucalagos.DTO.AboutMeDTO;
import com.ap.portfolio.lucalagos.Entity.AboutMe;
import com.ap.portfolio.lucalagos.Security.Controller.Message;
import com.ap.portfolio.lucalagos.Service.AboutMeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("about-me")
@CrossOrigin(origins = "https://frontend-port-ap-luca-lagos.web.app")
public class AboutMeController {

    @Autowired
    AboutMeService aboutMeService;

    @GetMapping("/list")
    public ResponseEntity<List<AboutMe>> GetAboutMes(){
        List<AboutMe> aboutMeList = aboutMeService.GetAboutMes();
        return new ResponseEntity(aboutMeList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<AboutMe> GetAboutMeById(@PathVariable("id") int id) {
        if (!aboutMeService.FindAboutMeById(id)) {
            return new ResponseEntity(new Message("La introduccion no existe"), HttpStatus.NOT_FOUND);
        }
        AboutMe aboutMe = aboutMeService.GetOneAboutMe(id).get();
        return new ResponseEntity(aboutMe, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> CreateAboutMe(@RequestBody AboutMeDTO aboutMeDTO){
        if(StringUtils.isBlank(aboutMeDTO.getDescription())){
            return new ResponseEntity(new Message("La descripcion es obligatoria"), HttpStatus.NOT_FOUND);
        }
        if(aboutMeService.FindAboutMeByDescription(aboutMeDTO.getDescription())){
            return new ResponseEntity(new Message("La introduccion ya existe"), HttpStatus.BAD_REQUEST);
        }
        AboutMe aboutMe = new AboutMe(aboutMeDTO.getDescription());
        aboutMeService.AddAboutMe(aboutMe);
        return new ResponseEntity(new Message("La introduccion ha sido creada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> UpdateAboutMe(@PathVariable("id") int id, @RequestBody AboutMeDTO aboutMeDTO){
        if(!aboutMeService.FindAboutMeById(id)){
            return new ResponseEntity(new Message("La introduccion no existe"), HttpStatus.NOT_FOUND);
        }
        if(aboutMeService.FindAboutMeByDescription(aboutMeDTO.getDescription()) && aboutMeService.GetByDescription(aboutMeDTO.getDescription()).get().getId() != id){
            return new ResponseEntity(new Message("La introduccion ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(aboutMeDTO.getDescription())){
            return new ResponseEntity(new Message("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        AboutMe aboutMe = aboutMeService.GetOneAboutMe(id).get();
        aboutMe.setDescription(aboutMeDTO.getDescription());

        aboutMeService.AddAboutMe(aboutMe);
        return new ResponseEntity(new Message("La introduccion ha sido actualizada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteAboutMe(@PathVariable("id") int id){
        if(!aboutMeService.FindAboutMeById(id)){
            return new ResponseEntity(new Message("La introduccion no existe"), HttpStatus.NOT_FOUND);
        }
        aboutMeService.DeleteAboutMe(id);
        return new ResponseEntity(new Message("La introduccion ha sido eliminada correctamente"), HttpStatus.OK);
    }
}
