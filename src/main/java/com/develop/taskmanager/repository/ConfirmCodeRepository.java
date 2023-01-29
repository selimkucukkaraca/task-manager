package com.develop.taskmanager.repository;

import com.develop.taskmanager.model.ConfirmCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmCodeRepository extends JpaRepository<ConfirmCode,Long>{

    ConfirmCode findConfirmCodeByCode(int code);
}
