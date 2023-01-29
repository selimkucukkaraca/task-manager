package com.develop.taskmanager.service;

import com.develop.taskmanager.model.ConfirmCode;
import com.develop.taskmanager.repository.ConfirmCodeRepository;
import org.springframework.stereotype.Component;

@Component
public class ConfirmCodeService {

    private final ConfirmCodeRepository confirmCodeRepository;

    public ConfirmCodeService(ConfirmCodeRepository confirmCodeRepository) {
        this.confirmCodeRepository = confirmCodeRepository;
    }

    public void save(ConfirmCode confirmCode){
        confirmCodeRepository.save(confirmCode);
    }

    public void delete(ConfirmCode confirmCode){
        confirmCodeRepository.delete(confirmCode);
    }
}
