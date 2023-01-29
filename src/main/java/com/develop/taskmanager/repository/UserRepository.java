package com.develop.taskmanager.repository;

import com.develop.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsUserByMail(String mail);
    Optional<User> findUserByMail(String mail);
}
