package com.develop.taskmanager.repository;

import com.develop.taskmanager.model.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeRepository extends JpaRepository<TaskType,Long> {
}
