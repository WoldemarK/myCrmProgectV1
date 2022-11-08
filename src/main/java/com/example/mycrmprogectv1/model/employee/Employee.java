package com.example.mycrmprogectv1.model.employee;

import com.example.mycrmprogectv1.model.company.Company;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Employee {

    private Long employeeId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String city;
    private String country;
    private String address;
    private String email;
    private String postOn;
    private int age;

    private LocalDateTime birth;
    private Company companyId;
    private TypePost post;

    public enum TypePost {
        MANAGER,
        PURCHASING,
        DIRECTOR,
        ADMINISTRATOR,
        LAWYER, ACCOUNTANT,
        WAREHOUSE_MANAGER,
        DEPARTMENT_HEAD,
        GENERAL_DIRECTOR,
        EXECUTIVE_DIRECTOR,
        SECRETARY,
        TECHNICAL_DIRECTOR
    }
}
