package com.example.aveklontesttask.model;

import com.example.aveklontesttask.entity.ProjectEntity;

public class Project {
    private Long id;
    private String name;
    private Task task;

    public static Project toModel(ProjectEntity entity){
        Project model = new Project();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

    public Project() {

    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName(){ return name;}
    public void setName(String name) { this.name = name; }
}
