package com.develop.taskmanager.controller;

import com.develop.taskmanager.dto.TaskTypeDto;
import com.develop.taskmanager.dto.request.CreateTaskTypeRequest;
import com.develop.taskmanager.service.TaskTypeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task-type")
@CrossOrigin
public class TaskTypeController {

    private final TaskTypeService taskTypeService;

    public TaskTypeController(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    @PostMapping
    public ResponseEntity<TaskTypeDto> save(@Valid @RequestBody CreateTaskTypeRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskTypeService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String type){
        taskTypeService.delete(type);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TaskTypeDto>> getAll(){
        return ResponseEntity
                .ok(taskTypeService.getAll());
    }
}