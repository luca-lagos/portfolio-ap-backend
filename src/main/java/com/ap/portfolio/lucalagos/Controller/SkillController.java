package com.ap.portfolio.lucalagos.Controller;

import com.ap.portfolio.lucalagos.DTO.SkillDTO;
import com.ap.portfolio.lucalagos.Entity.Skill;
import com.ap.portfolio.lucalagos.Security.Controller.Message;
import com.ap.portfolio.lucalagos.Service.SkillService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skill")
@CrossOrigin(origins = "https://frontend-port-ap-luca-lagos.web.app")
public class SkillController {
    @Autowired
    SkillService skillService;

    @GetMapping("/list")
    public ResponseEntity<List<Skill>> GetSkills(){
        List<Skill> skillList = skillService.GetSkills();
        return new ResponseEntity(skillList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> GetSkillById(@PathVariable("id") int id){
        if(!skillService.FindSkillById(id)){
            return new ResponseEntity(new Message("La habilidad no existe"), HttpStatus.NOT_FOUND);
        }
        Skill skill = skillService.GetOneSkill(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> CreateSkill(@RequestBody SkillDTO skillDTO){
        if(StringUtils.isBlank(skillDTO.getName())){
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(skillService.FindSkillByName(skillDTO.getName())){
            return new ResponseEntity(new Message("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = new Skill(skillDTO.getName(), skillDTO.getPercentage());
        skillService.AddSkill(skill);
        return new ResponseEntity(new Message("La habilidad ha sido creada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> UpdateSkill(@PathVariable("id") int id,@RequestBody SkillDTO skillDTO){
        if(StringUtils.isBlank(skillDTO.getName())){
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(skillService.FindSkillByName(skillDTO.getName()) && skillService.GetByName(skillDTO.getName()).get().getId() != id){
            return new ResponseEntity(new Message("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(!skillService.FindSkillById(id)){
            return new ResponseEntity(new Message("La habilidad no existe"), HttpStatus.NOT_FOUND);
        }
        Skill skill = skillService.GetOneSkill(id).get();
        skill.setName(skillDTO.getName());
        skill.setPercentage(skillDTO.getPercentage());

        skillService.AddSkill(skill);
        return new ResponseEntity(new Message("La habilidad ha sido actualizada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteSkill(@PathVariable("id") int id){
        if(!skillService.FindSkillById(id)){
            return new ResponseEntity(new Message("La habilidad no existe"), HttpStatus.NOT_FOUND);
        }
        skillService.DeleteSkill(id);
        return new ResponseEntity(new Message("La habilidad ha sido eliminada correctamente"), HttpStatus.OK);
    }
}
