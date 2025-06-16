package com.example.taskmanagerapi.service;


import com.example.taskmanagerapi.dto.TaskDTO;
import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasksByStudentId(Long studentId);
    TaskDTO createTask(TaskDTO taskDto, Long studentId);
    TaskDTO updateTask(Long id, TaskDTO taskDto);
    void deleteTask(Long id);
}
