package com.develop.taskmanager.dto.converter;

import com.develop.taskmanager.dto.TaskDto;
import com.develop.taskmanager.dto.request.CreateTaskRequest;
import com.develop.taskmanager.model.Task;
import com.develop.taskmanager.service.TaskTypeService;
import com.develop.taskmanager.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter {

    private final UserConverter userConverter;
    private final TaskTypeConverter taskTypeConverter;
    private final UserService userService;
    private final TaskTypeService taskTypeService;

    public TaskConverter(UserConverter userConverter, TaskTypeConverter taskTypeConverter, UserService userService, TaskTypeService taskTypeService) {
        this.userConverter = userConverter;
        this.taskTypeConverter = taskTypeConverter;
        this.userService = userService;
        this.taskTypeService = taskTypeService;
    }

    public TaskDto convertTaskToUserDto(Task from){
        return new TaskDto(
                from.getTitle(),
                from.getDescription(),
                from.getImageUrl(),
                userConverter.convertUserToUserDto(from.getAssigned()),
                taskTypeConverter.convertTaskTypeToTaskTypeDto(from.getTaskType()),
                from.getPublicId(),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public Task toEntity(CreateTaskRequest request){
        return new Task(
                request.getTitle(),
                request.getDescription(),
                request.getImageUrl(),
                userService.getUserByMail(request.getAssignedMail()),
                taskTypeService.getTaskTypeByType(request.getTaskType())
        );
    }
}
