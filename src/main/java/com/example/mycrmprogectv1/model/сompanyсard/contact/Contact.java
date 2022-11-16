package com.example.mycrmprogectv1.model.сompanyсard.contact;

import com.example.mycrmprogectv1.model.сompanyсard.Company;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Contact {

    private Long Id;
    private String name;
    private String surname;
    /**
     *
     */
    private List<String> phoneNumber;
    /**
     *
     */
    private List<String> email;
    private String post;

    private Company companyId;

    private String comment;



    /**
     * У одного контакты может быть несколько должностей
     * One contact can have several positions
     */
    private List<ContactTypePost> contactTypePost;

    /**
     * Типы контакта, которые можно выбрать при заполнении карточки
     * Contact types that can be selected when filling out the card
     */
    public enum ContactTypePost {
        DIRECTOR,
        MANAGER,
        CLIENT,
        COMPETITOR,
        DIRECTOR_IT
    }

}
