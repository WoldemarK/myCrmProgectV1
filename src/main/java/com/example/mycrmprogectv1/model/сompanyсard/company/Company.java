package com.example.mycrmprogectv1.model.сompanyсard.company;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Company {

    private Long Id;
    private String name;
    private String phoneNumber;
    private String city;
    private String country;
    private String address;
    private String email;
    private String website;

    private String comment;
    private LocalDateTime creation;
    private LocalDateTime update;


    private String typeCompany;

    public Company() {
        LocalDateTime date = LocalDateTime.now();
        this.creation = date;
        this.update = date;
        this.country = "Россия";
    }
}

