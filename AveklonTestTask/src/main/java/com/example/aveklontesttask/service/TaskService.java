package com.example.aveklontesttask.service;


import com.example.aveklontesttask.entity.TaskEntity;
import com.example.aveklontesttask.exception.TaskAlreadyExistsException;
import com.example.aveklontesttask.exception.TaskNotFoundException;
import com.example.aveklontesttask.model.Task;
import com.example.aveklontesttask.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public TaskEntity createTask(TaskEntity task) throws TaskAlreadyExistsException {
        if (taskRepo.findByTaskName(task.getName()) != null){
            throw new TaskAlreadyExistsException("Task with this name already exists");
        }
        return taskRepo.save(task);
    }

    public Long delete(Long id){
        taskRepo.deleteById(id);
        return id;
    }

    public Task getOne(Long id) throws TaskNotFoundException {
        TaskEntity task = taskRepo.findById(id).get();
        if(task == null){
            throw new TaskNotFoundException("User Not Found");
        }
        return Task.toModel(task);
    }

    public TaskEntity edit(TaskEntity task) {

        return task;
    }
}
