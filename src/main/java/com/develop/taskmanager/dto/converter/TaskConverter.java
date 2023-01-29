package com.develop.taskmanager.dto.converter;

import com.develop.taskmanager.dto.TaskDto;
import com.develop.taskmanager.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter {

    private final UserConverter userConverter;
    private final TaskTypeConverter taskTypeConverter;

    public TaskConverter(UserConverter userConverter, TaskTypeConverter taskTypeConverter) {
        this.userConverter = userConverter;
        this.taskTypeConverter = taskTypeConverter;
    }

    public TaskDto convertTaskToUserDto(Task from){
        return new TaskDto(
                from.getTitle(),
                from.getDescription(),
                from.getImageUrl(),
                userConverter.convertUserToUserDto(from.getAssigned()),
                taskTypeConverter.convertTaskTypeToTaskTypeDto(from.getTaskType()),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }
}
