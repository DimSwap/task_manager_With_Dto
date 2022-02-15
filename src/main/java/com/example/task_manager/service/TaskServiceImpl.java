package com.example.task_manager.service;

import com.example.task_manager.entity.Task;
import com.example.task_manager.repository.TaskRepo;
import org.springframework.stereotype.Service;


import java.time.LocalDate;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }


    @Override
    public Task createTask(String title, Boolean isCompleted) {
        Task task = mapTask(title, isCompleted);
        return taskRepo.save(task);
    }

    @Override
    public Task updateTask(Long id, String title, Boolean isCompleted) {
        Task task = mapTask(title, isCompleted);
        task.setId(id);
        return taskRepo.save(task);
    }

    @Override
    public Task gettaskById(Long id) {
        return taskRepo.findById(id).get();

    }

    @Override
    public void deletetaskById(Long id) {
         taskRepo.deleteById(id);

    }

    private Task mapTask(String title, Boolean isCompleted) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(isCompleted);
        task.setLocalDate(LocalDate.now());
        return task;
    }
}
