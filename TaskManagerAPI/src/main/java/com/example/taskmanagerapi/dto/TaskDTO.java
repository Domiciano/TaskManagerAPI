package com.example.taskmanagerapi.dto;

import com.example.taskmanagerapi.entity.Student;
import jakarta.persistence.*;

public class TaskDTO {
    private String title;
    private String status;
    private String description;

    // Constructors
    public TaskDTO() {
    }

    public TaskDTO(String title, String status, String description) {
        this.title = title;
        this.status = status;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}