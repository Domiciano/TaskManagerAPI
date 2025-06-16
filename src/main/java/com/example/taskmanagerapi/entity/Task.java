package com.example.taskmanagerapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String status;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY) // Se recomienda FetchType.LAZY para relaciones ManyToOne
    @JoinColumn(name = "student_id") // Nombre de la columna de la clave foránea en la tabla 'tasks'
    private Student student;

    public Task() {
    }

    public Task(String title, String status, String description, Student student) {
        this.title = title;
        this.status = status;
        this.description = description;
        this.student = student;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}