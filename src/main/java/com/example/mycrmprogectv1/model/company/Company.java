package com.example.mycrmprogectv1.model.company;
import com.example.mycrmprogectv1.model.contact.Contact;
import lombok.Data;
import org.springframework.stereotype.Component;

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
    private LocalDateTime creation;

    private Contact contactId;
    private TypeCompany typeCompany;

    public enum TypeCompany {
        CLIENT,
        SUPPLIER,
        COMPETITOR,
        PARTNER
    }

}

