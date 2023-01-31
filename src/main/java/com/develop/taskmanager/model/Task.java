package com.develop.taskmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    @ManyToOne
    private User assigned;
    @ManyToOne
    private TaskType taskType;
    private String publicId = UUID.randomUUID().toString();

    public Task(String title, String description, String imageUrl, User assigned, TaskType taskType) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.assigned = assigned;
        this.taskType = taskType;
    }
}
