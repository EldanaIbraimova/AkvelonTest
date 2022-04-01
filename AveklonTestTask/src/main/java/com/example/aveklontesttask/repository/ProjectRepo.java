package com.example.aveklontesttask.repository;

import com.example.aveklontesttask.entity.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<ProjectEntity, Long> {
    ProjectEntity findByProjectName(String projectname);
}
