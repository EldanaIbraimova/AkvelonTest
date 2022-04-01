package com.example.aveklontesttask.repository;

import com.example.aveklontesttask.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;


public interface TaskRepo extends CrudRepository<TaskEntity, Long> {
    TaskEntity findByTaskName(String name);
}
