package com.example.mycrmprogectv1.model.tasc;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Status {
    private Long statusId;
    private String name;
    private TypeStatus status;


    public enum TypeStatus {
        IN_WORK,
        DONE,
        CLOSED_IMPLEMENTED,
        CLOSED_NOT_IMPLEMENTED,
        TAKE_A_PAUSE
    }
}
