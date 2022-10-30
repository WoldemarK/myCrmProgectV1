package com.example.mycrmprogectv1.model.tasc;

import lombok.Data;

@Data
public class Action {
    private Long id;
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
