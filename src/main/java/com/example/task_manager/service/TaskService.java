package com.example.task_manager.service;
import com.example.task_manager.entity.Task;

public interface TaskService {
    Task createTask(String title, Boolean isCompleted);
    Task updateTask(Long id,String title,Boolean isCompleted);
    Task gettaskById(Long id);
    void deletetaskById(Long id);
}
