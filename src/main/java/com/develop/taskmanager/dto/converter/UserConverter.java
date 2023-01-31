package com.develop.taskmanager.dto.converter;

import com.develop.taskmanager.dto.UserDto;
import com.develop.taskmanager.dto.UserTypeDto;
import com.develop.taskmanager.dto.request.CreateUserRequest;
import com.develop.taskmanager.model.User;
import com.develop.taskmanager.service.UserTypeService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private final UserTypeService userTypeService;
    private final PasswordEncoder passwordEncoder;

    public UserConverter(UserTypeService userTypeService,
                         PasswordEncoder passwordEncoder) {
        this.userTypeService = userTypeService;
        this.passwordEncoder = passwordEncoder;
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
                passwordEncoder.encode(request.getPassword()),
                request.getMail(),
                userTypeService.getUserTypeByType(request.getUserType())
        );
    }
}
