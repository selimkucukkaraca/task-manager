package com.develop.taskmanager.service;

import com.develop.taskmanager.dto.TaskTypeDto;
import com.develop.taskmanager.dto.request.CreateTaskTypeRequest;
import com.develop.taskmanager.model.TaskType;
import com.develop.taskmanager.repository.TaskTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskTypeService {

    private final TaskTypeRepository taskTypeRepository;

    public TaskTypeService(TaskTypeRepository taskTypeRepository) {
        this.taskTypeRepository = taskTypeRepository;
    }

    public TaskType getTaskTypeByType(String type){
        return taskTypeRepository.findTaskTypeByType(type);
    }

    public TaskTypeDto save(CreateTaskTypeRequest request){
        var saved = new TaskType(request.getType());
        taskTypeRepository.save(saved);
        return new TaskTypeDto(saved.getType());
    }

    public void delete(String type){
        var fromType = getTaskTypeByType(type);
        taskTypeRepository.delete(fromType);
    }

    public List<TaskTypeDto> getAll(){
        return taskTypeRepository.findAll()
                .stream()
                .map(taskType -> new TaskTypeDto(taskType.getType()))
                .collect(Collectors.toList());
    }
}
