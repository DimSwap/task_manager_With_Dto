package com.example.task_manager.web;

import com.example.task_manager.dto.TaskDto;
import com.example.task_manager.entity.Task;
import com.example.task_manager.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Контроллер task", description = "Взимодействие с task ")
public class TaskWeb {
    private TaskService taskService;

    @Autowired
    public TaskWeb(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    @Operation(summary = "Создание task",
            description = "Позволяет создать task пользователя")
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto) {
        Task task = taskService.createTask(taskDto.getTitle(), taskDto.isCompleted());
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PutMapping
    @Operation(summary = "Обновление task",
            description = "Позволяет обновить task пользователя")
    public ResponseEntity<Task> updateTask(@RequestBody TaskDto taskDto) {
        Task task = taskService.updateTask(taskDto.getId(), taskDto.getTitle(), taskDto.isCompleted());
        return ResponseEntity.ok(task);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "получение task",
            description = "Позволяет получить task пользователя по id")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        Task task = taskService.gettaskById(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Удаление task",
            description = "Позволяет удалить task пользователя по id")
    public void deleteTaskById(@PathVariable("id") Long id) {
        taskService.deletetaskById(id);
    }

}
