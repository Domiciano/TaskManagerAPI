package com.example.taskmanagerapi.controller;

import com.example.taskmanagerapi.dto.TaskDTO; // Import TaskDTO
import com.example.taskmanagerapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<TaskDTO>> getTasksByStudentId(@PathVariable Long studentId) {
        List<TaskDTO> tasks = taskService.getTasksByStudentId(studentId);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/student/{studentId}")
    public ResponseEntity<TaskDTO> createTask(@PathVariable Long studentId, @RequestBody TaskDTO taskDto) {
        TaskDTO createdTask = taskService.createTask(taskDto, studentId);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDto) {
        TaskDTO updatedTask = taskService.updateTask(id, taskDto);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}