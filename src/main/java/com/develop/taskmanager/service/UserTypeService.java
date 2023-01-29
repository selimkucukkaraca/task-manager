package com.develop.taskmanager.service;

import com.develop.taskmanager.model.UserType;
import com.develop.taskmanager.repository.UserTypeRepository;
import org.springframework.stereotype.Component;

@Component
public class UserTypeService {

    private final UserTypeRepository userTypeRepository;

    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public UserType getUserTypeByType(String type) {
        return userTypeRepository.findUserTypeByType(type);
    }
}
