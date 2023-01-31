package com.develop.taskmanager.repository;

import com.develop.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {
    Optional<Task> findTaskByPublicId (String publicId);
}
