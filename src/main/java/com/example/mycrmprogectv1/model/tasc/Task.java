package com.example.mycrmprogectv1.model.tasc;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Task {
    private Long id;

    private String name;
    private String description;
    private Employee answerable;


    private LocalDateTime creation;
    private LocalDateTime start;
    private LocalDateTime ending;

    private Action action;
    private Status status;

    public Task() {
        this.creation = LocalDateTime.now();
    }
}
