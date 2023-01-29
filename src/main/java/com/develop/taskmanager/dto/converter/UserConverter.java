package com.develop.taskmanager.dto.converter;

import com.develop.taskmanager.dto.UserDto;
import com.develop.taskmanager.dto.UserTypeDto;
import com.develop.taskmanager.dto.request.CreateUserRequest;
import com.develop.taskmanager.model.User;
import com.develop.taskmanager.service.UserTypeService;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private final UserTypeService userTypeService;

    public UserConverter(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    public UserDto convertUserToUserDto(User from){
        return new UserDto(
                from.getUsername(),
                from.getMail(),
                new UserTypeDto(from.getUserType().getType()),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public User toEntity(CreateUserRequest request){
        return new User(
                request.getUsername(),
                request.getPassword(),
                request.getMail(),
                userTypeService.getUserTypeByType(request.getUserType())
        );
    }
}
