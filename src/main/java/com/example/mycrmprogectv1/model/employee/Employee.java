package com.example.mycrmprogectv1.model.employee;

import com.example.mycrmprogectv1.model.сompanyсard.company.Company;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Employee {

    private Long Id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String city;
    private String country;
    private String address;
    private String email;
    private String post;
    private Long age;
    private LocalDateTime creation;
    private LocalDateTime update;

    public Employee() {
        LocalDateTime date = LocalDateTime.now();
        this.creation = date;
        this.update = date;
        this.country = "Россия";
    }

}
