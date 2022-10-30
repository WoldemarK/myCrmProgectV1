package com.example.mycrmprogectv1.model.contact;

import com.example.mycrmprogectv1.model.company.Company;
import lombok.Data;

@Data
public class Contact {

    private Long contactId;

    private String name;
    private String surname;
    private String phoneNumber;
    private String city;
    private String country;
    private String address;
    private String email;
    private String postOn;

    private Company companyId;
    private TypePost post;

    public Contact() {
        this.post = getPost();
    }

    public enum TypePost {
        MANAGER, PURCHASING, DIRECTOR,
    }
}
