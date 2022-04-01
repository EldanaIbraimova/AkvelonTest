package com.example.aveklontesttask.service;

import com.example.aveklontesttask.entity.ProjectEntity;
import com.example.aveklontesttask.exception.ProjectAlreadyExistsException;
import com.example.aveklontesttask.exception.ProjectNotFoundException;
import com.example.aveklontesttask.model.Project;
import com.example.aveklontesttask.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public ProjectEntity createProject(ProjectEntity project) throws ProjectAlreadyExistsException{
        if (projectRepo.findByProjectName(project.getName()) != null){
            throw new ProjectAlreadyExistsException("Project with this name already exists");
        }

        return projectRepo.save(project);
    }

    public Project getOne(Long id) throws ProjectNotFoundException {
        ProjectEntity project = projectRepo.findById(id).get();
        if (project == null){
            throw new ProjectNotFoundException("User Not Found");
        }
        return Project.toModel(project);
    }

    public Long delete (Long id){
        projectRepo.deleteById(id);
        return id;
    }

    public ProjectEntity edit(ProjectEntity project) throws ProjectAlreadyExistsException {
        return  project;
    }
}
