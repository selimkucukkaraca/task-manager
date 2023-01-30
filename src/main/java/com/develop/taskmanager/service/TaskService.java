package com.develop.taskmanager.service;

import com.develop.taskmanager.dto.TaskDto;
import com.develop.taskmanager.dto.converter.TaskConverter;
import com.develop.taskmanager.dto.request.CreateTaskRequest;
import com.develop.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskConverter taskConverter;

    public TaskService(TaskRepository taskRepository,
                       TaskConverter taskConverter) {
        this.taskRepository = taskRepository;
        this.taskConverter = taskConverter;
    }

    public TaskDto save(CreateTaskRequest request){
        var saved = taskConverter.toEntity(request);

        taskRepository.save(saved);
        return taskConverter.convertTaskToUserDto(saved);
    }

}
