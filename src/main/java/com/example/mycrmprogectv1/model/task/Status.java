package com.example.mycrmprogectv1.model.task;

import lombok.Data;

@Data
public class Status {
    private Long statusId;
    private String name;
    private TypeStatus typeStatus;


    public enum TypeStatus {
        IN_WORK,
        DONE,
        CLOSED_IMPLEMENTED,
        CLOSED_NOT_IMPLEMENTED,
        TAKE_A_PAUSE
    }
}
