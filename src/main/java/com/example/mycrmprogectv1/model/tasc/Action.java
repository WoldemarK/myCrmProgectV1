package com.example.mycrmprogectv1.model.tasc;

import lombok.Data;

@Data
public class Action {
    private Long actionId;
    private String name;
    private TypeAction typeAction;


    public enum TypeAction {
        CALL,
        SHOUT,
        PREPARE,
        BOOK_A_MEETING,
        CALL_BACK
    }
}
