package com.example.mycrmprogectv1.model.сompanyсard;

import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Company {

    private Long companyId;
    private String name;
    private String phoneNumber;
    private String city;
    private String country;
    private String address;
    private String email;
    private String website;
    private String comment;

    private String typeCompany;
    private LocalDateTime creation;
    private Contact contactId;
    private CompanyType companyType;

    public enum CompanyType {
        CLIENT, COMPETITOR, SUPPLIER
    }
}

