package com.develop.taskmanager.controller;

import com.develop.taskmanager.dto.UserTypeDto;
import com.develop.taskmanager.dto.request.CreateUserTypeRequest;
import com.develop.taskmanager.service.UserTypeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-type")
@CrossOrigin
public class UserTypeController {

    private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @PostMapping
    public ResponseEntity<UserTypeDto> save(@Valid @RequestBody CreateUserTypeRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userTypeService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String type){
        userTypeService.delete(type);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserTypeDto>> getAll(){
        return ResponseEntity
                .ok(userTypeService.getAll());
    }
}
