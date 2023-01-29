package com.develop.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserDto {
    private String username;
    private String mail;
    private UserTypeDto userTypeDto;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}