package com.example.aveklontesttask.model;

import com.example.aveklontesttask.entity.TaskEntity;

public class Task {
    private Long id;
    private String name;
    private String description;

    public static Task toModel(TaskEntity entity){
        Task model = new Task();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

    public Task() {

    }

    public Long getId() { return id; }
    public void setId(Long id) {this.id = id; }
    public String getName() {return name;}
    public void setName(String name) { this.name = name; }
}
