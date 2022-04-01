package com.example.aveklontesttask.controller;

import com.example.aveklontesttask.entity.TaskEntity;
import com.example.aveklontesttask.exception.TaskNotFoundException;
import com.example.aveklontesttask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity createTask(@RequestBody TaskEntity task){
        try{
            taskService.createTask(task);
            return ResponseEntity.ok().body("Task successfully created");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("There occurs some errors while creating new task. Try again");
        }
    }

    @GetMapping
    public ResponseEntity getOneTask(@RequestParam Long id){
        try{
            return ResponseEntity.ok(taskService.getOne(id));
        }catch (TaskNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("There occurs some errors while getting task. Try again");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editTask(@RequestBody TaskEntity task) throws TaskNotFoundException {
        try {
            return ResponseEntity.ok(taskService.edit(task));
        }catch (Exception e ){
            return ResponseEntity.badRequest().body("There occur some errors while editing. Try again");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(taskService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("There occurs some errors while deleting task. Try again");
        }
    }
}
