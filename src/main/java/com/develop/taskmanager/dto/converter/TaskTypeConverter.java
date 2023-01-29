package com.develop.taskmanager.dto.converter;

import com.develop.taskmanager.dto.TaskTypeDto;
import com.develop.taskmanager.model.TaskType;
import org.springframework.stereotype.Component;

@Component
public class TaskTypeConverter {

    public TaskTypeDto convertTaskTypeToTaskTypeDto(TaskType from){
        return new TaskTypeDto(
                from.getType()
        );
    }
}
