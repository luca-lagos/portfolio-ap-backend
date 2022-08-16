package com.ap.portfolio.lucalagos.Controller;

import com.ap.portfolio.lucalagos.DTO.ProjectDTO;
import com.ap.portfolio.lucalagos.Entity.Project;
import com.ap.portfolio.lucalagos.Security.Controller.Message;
import com.ap.portfolio.lucalagos.Service.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/list")
    public ResponseEntity<List<Project>> GetProjects(){
        List<Project> projectList = projectService.GetProjects();
        return new ResponseEntity(projectList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> GetProjectById(@PathVariable("id") int id){
        if(!projectService.FindProjectById(id)){
            return new ResponseEntity(new Message("El proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        Project project = projectService.GetOneProject(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> CreateProject(@RequestBody ProjectDTO projectDTO){
        if(StringUtils.isBlank(projectDTO.getTitle())){
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(projectService.FindProjectByTitle(projectDTO.getTitle())){
            return new ResponseEntity(new Message("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        Project project = new Project(projectDTO.getTitle(), projectDTO.getDescription(), projectDTO.getLinkWeb(), projectDTO.getProjectStart(), projectDTO.getProjectEnd(), projectDTO.isActualProject());
        projectService.AddProject(project);
        return new ResponseEntity(new Message("El proyecto ha sido creada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> UpdateProject(@PathVariable("id") int id, @RequestBody ProjectDTO projectDTO){
        if(!projectService.FindProjectById(id)){
            return new ResponseEntity(new Message("El proyecto no existe"), HttpStatus.BAD_REQUEST);
        }
        if(projectService.FindProjectByTitle(projectDTO.getTitle()) && projectService.GetByTitle(projectDTO.getTitle()).get().getId() != id){
            return new ResponseEntity(new Message("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(projectDTO.getTitle())){
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Project project = projectService.GetOneProject(id).get();
        project.setTitle(projectDTO.getTitle());
        project.setDescription(projectDTO.getDescription());
        project.setLinkWeb(projectDTO.getLinkWeb());
        project.setProjectStart(projectDTO.getProjectStart());
        project.setProjectEnd(projectDTO.getProjectEnd());
        project.setActualProject(projectDTO.isActualProject());

        projectService.AddProject(project);
        return new ResponseEntity(new Message("El proyecto ha sido actualizado correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteProject(@PathVariable("id") int id){
        if(!projectService.FindProjectById(id)){
            return new ResponseEntity(new Message("El proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        projectService.DeleteProject(id);
        return new ResponseEntity(new Message("El proyecto ha sido eliminado correctamente"), HttpStatus.OK);
    }
}
