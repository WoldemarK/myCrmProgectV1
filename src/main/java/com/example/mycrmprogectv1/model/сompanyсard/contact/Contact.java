package com.example.mycrmprogectv1.model.сompanyсard.contact;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Contact {

    private Long Id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String post;
    private String comment;
    private LocalDateTime creation;
    private LocalDateTime update;

    public Contact() {
        LocalDateTime date = LocalDateTime.now();
        this.creation = date;
        this.update = date;
    }
}
