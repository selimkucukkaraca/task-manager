package com.develop.taskmanager.dto.request;

import lombok.Data;
import com.develop.taskmanager.model.TaskType;

@Data
public class CreateTaskRequest {
    private String title;
    private String description;
    private String imageUrl;
    private String assigned;
    private TaskType taskType;
}