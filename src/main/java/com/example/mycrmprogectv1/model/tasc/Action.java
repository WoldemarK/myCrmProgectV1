package com.example.mycrmprogectv1.model.tasc;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Action {
    private Long actionId;
    private String name;
    private TypeAction action;

    public enum TypeAction {
        CALL,
        SHOUT,
        PREPARE,
        BOOK_A_MEETING,
        CALL_BACK
    }
}
