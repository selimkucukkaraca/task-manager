package com.develop.taskmanager.repository;

import com.develop.taskmanager.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType,Long> {
    UserType findUserTypeByType(String type);
}
