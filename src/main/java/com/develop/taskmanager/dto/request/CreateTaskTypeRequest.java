package com.develop.taskmanager.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTaskTypeRequest {
    @NotBlank
    private String type;
}

