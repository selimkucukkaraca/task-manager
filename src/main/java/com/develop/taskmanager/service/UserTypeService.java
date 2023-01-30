package com.develop.taskmanager.service;

import com.develop.taskmanager.dto.UserTypeDto;
import com.develop.taskmanager.dto.request.CreateUserTypeRequest;
import com.develop.taskmanager.model.UserType;
import com.develop.taskmanager.repository.UserTypeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserTypeService {

    private final UserTypeRepository userTypeRepository;

    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public UserType getUserTypeByType(String type) {
        return userTypeRepository.findUserTypeByType(type);
    }

    public UserTypeDto save(CreateUserTypeRequest request){
        var saved = new UserType(request.getType());
        userTypeRepository.save(saved);
        return new UserTypeDto(saved.getType());
    }

    public void delete(String type){
        var fromType = getUserTypeByType(type);
        userTypeRepository.delete(fromType);
    }

    public List<UserTypeDto> getAll(){
        return userTypeRepository.findAll()
                .stream()
                .map(userType -> new UserTypeDto(userType.getType()))
                .collect(Collectors.toList());

    }
}
