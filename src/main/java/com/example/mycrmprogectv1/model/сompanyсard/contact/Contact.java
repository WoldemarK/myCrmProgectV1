package com.example.mycrmprogectv1.model.сompanyсard.contact;

import com.example.mycrmprogectv1.model.сompanyсard.Company;
import lombok.Data;

@Data
public class Contact {

    private Long contactId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String post;
    private Company companyId;

    private ContactTypePost contactTypePost;

   public enum ContactTypePost {
        DIRECTOR,
        MANAGER,
        CLIENT,
        COMPETITOR,
        DIRECTOR_IT
    }

}
