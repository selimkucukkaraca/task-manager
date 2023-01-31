package com.develop.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TaskDto {
    private String title;
    private String description;
    private String imageUrl;
    private UserDto assigned;
    private TaskTypeDto taskTypeDto;
    private String publicId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
