package com.develop.taskmanager.controller;

import com.develop.taskmanager.dto.TaskDto;
import com.develop.taskmanager.dto.request.CreateTaskRequest;
import com.develop.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task")
@CrossOrigin
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDto> save(@Valid @RequestBody CreateTaskRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String publicId){
        taskService.delete(publicId);
        return ResponseEntity.noContent().build();
    }


}
