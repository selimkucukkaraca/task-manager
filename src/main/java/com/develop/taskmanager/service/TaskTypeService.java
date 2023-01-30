package com.develop.taskmanager.service;

import com.develop.taskmanager.model.TaskType;
import com.develop.taskmanager.repository.TaskTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskTypeService {

    private final TaskTypeRepository taskTypeRepository;

    public TaskTypeService(TaskTypeRepository taskTypeRepository) {
        this.taskTypeRepository = taskTypeRepository;
    }

    public TaskType getTaskTypeByType(String type){
        return taskTypeRepository.findTaskTypeByType(type);
    }
}
