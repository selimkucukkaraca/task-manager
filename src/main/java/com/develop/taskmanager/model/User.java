package com.develop.taskmanager.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String mail;
    private boolean isActive = false;
    @ManyToOne
    private UserType userType;
    @OneToOne
    private ConfirmCode confirmCode;

    public User(String username, String password, String mail, UserType userType) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.userType = userType;
    }
}