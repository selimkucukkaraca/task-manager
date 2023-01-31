package com.develop.taskmanager.dto.request;

import lombok.Data;

@Data
public class CreateTaskRequest {
    private String title;
    private String description;
    private String imageUrl;
    private String assignedMail;
    private String taskType;
}