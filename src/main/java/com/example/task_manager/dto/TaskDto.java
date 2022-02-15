package com.example.task_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long Id;
    private String title;
    private boolean isCompleted;
    private LocalDate localDate;

}
