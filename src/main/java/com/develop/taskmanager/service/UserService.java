package com.develop.taskmanager.service;

import com.develop.taskmanager.dto.UserDto;
import com.develop.taskmanager.dto.converter.UserConverter;
import com.develop.taskmanager.dto.request.CreateUserRequest;

import com.develop.taskmanager.model.ConfirmCode;
import com.develop.taskmanager.model.User;
import com.develop.taskmanager.repository.ConfirmCodeRepository;
import com.develop.taskmanager.repository.UserRepository;
import com.develop.taskmanager.util.MailSendService;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.develop.taskmanager.util.MailConstant.*;

@Service
public class UserService {

    private final MailSendService mailSendService;
    private final ConfirmCodeService confirmCodeService;
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final ConfirmCodeRepository confirmCodeRepository;

    public UserService(MailSendService mailSendService,
                       ConfirmCodeService confirmCodeService,
                       UserRepository userRepository,
                       UserConverter userConverter,
                       ConfirmCodeRepository confirmCodeRepository) {
        this.mailSendService = mailSendService;
        this.confirmCodeService = confirmCodeService;
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.confirmCodeRepository = confirmCodeRepository;
    }

    public UserDto save(CreateUserRequest request){
        var saved = userConverter.toEntity(request);

        if (userRepository.existsUserByMail(saved.getMail()) || Objects.isNull(saved.getUserType())) {
            throw new RuntimeException();
        }
        userRepository.save(saved);
        return userConverter.convertUserToUserDto(saved);
    }

    public UserDto getByMail(String mail) {
        User fromDbUser = userRepository.findUserByMail(mail)
                .orElseThrow(RuntimeException::new);

        return userConverter.convertUserToUserDto(fromDbUser);
    }

    public void delete(String mail){
        var fromUser = getUserByMail(mail);
        userRepository.delete(fromUser);
    }

    public void sendConfirmCode(String mail){
        var user = getUserByMail(mail);

        ConfirmCode confirmCode = new ConfirmCode();
        confirmCodeService.save(confirmCode);
        user.setConfirmCode(confirmCode);
        userRepository.save(user);

        String description = String.format(CONFIRM_CODE_DESCRIPTION, confirmCode.getCode());

        mailSendService.sendMail(user.getMail(),CONFIRM_CODE_TITLE,description);
    }

    public UserDto activeUser(String mail,int code){
        var user = getUserByMail(mail);
        ConfirmCode confirmCode = confirmCodeRepository.findConfirmCodeByCode(code);

        if (user.getConfirmCode().getCode() == code) {
            user.setActive(true);
            confirmCodeRepository.deleteById(confirmCode.getId());
            userRepository.save(user);
            return userConverter.convertUserToUserDto(user);
        }
        return null;
    }

    public UserDto deactivateUser(String mail) {
        var fromDbUser = getUserByMail(mail);
        fromDbUser.setActive(false);
        userRepository.save(fromDbUser);
        return userConverter.convertUserToUserDto(fromDbUser);
    }

    public User getUserByMail(String mail){
        return userRepository.findUserByMail(mail)
                .orElseThrow(RuntimeException::new);
    }
}
