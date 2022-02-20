package com.example.task_manager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность task")
public class TaskDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long Id;

    @Schema(description = "Заголовок задачи")
    private String title;

    @Schema(description = "Состояние task (Выполнена или не выполнена)")
    private boolean isCompleted;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate localDate;

}
