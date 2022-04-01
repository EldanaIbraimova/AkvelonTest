package com.example.aveklontesttask.controller;

import com.example.aveklontesttask.entity.ProjectEntity;
import com.example.aveklontesttask.exception.ProjectAlreadyExistsException;
import com.example.aveklontesttask.exception.ProjectNotFoundException;
import com.example.aveklontesttask.service.ProjectService;
import com.example.aveklontesttask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity createProject(@RequestBody ProjectEntity project){
        try{
            projectService.createProject(project);
            return ResponseEntity.ok().body("Project successfully created");
        }catch (ProjectAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("There occurs somme errors while creating project. Try again");
        }

    }

    @GetMapping
    public ResponseEntity getOneProject(@RequestParam Long id){
        try {
            return ResponseEntity.ok(projectService.getOne(id));
        }catch (ProjectNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("There occurs some errors");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id){
        try {
            return ResponseEntity.ok(projectService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("There occurs some errors");
        }
    }

    @PutMapping
    public ResponseEntity editProject(@RequestParam ProjectEntity project){
        try {
            return ResponseEntity.ok(projectService.edit(project));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("There occurs some errors");
        }
    }

}
