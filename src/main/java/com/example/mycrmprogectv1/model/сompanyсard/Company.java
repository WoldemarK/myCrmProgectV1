package com.example.mycrmprogectv1.model.сompanyсard;

import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
public class Company {

    private Long companyId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String city;
    private String country;
    private String address;
    private String email;
    private String website;
    /**
     * Произвольное описание компании, дополнение которые пригодятся в дальнейшей работе с компанией
     */
    private String comment;
    /**
     * Если тип не подходит то указать свой вариант
     */
    private String typeCompany;

    private LocalDateTime creation;
    private LocalDateTime update;

    /**
     * Соотношения, у одной компании может быть много контактов
     * Relationships, one company can have many contacts
     */
    private List<Contact> contactId;

    /**
     * Соотношения, компания может быть как покупателем так и поставщиком
     * Relationships, a company can be both a buyer and a supplie
     */
    private List<CompanyType> companyType;

    /**
     * По молчанию все компании их России, при желании можно изменить
     * При создании компании не явно создается контакт,
     * так же автоматически добавляется дата создания
     * By silence, all companies are from Russia, if desired, you can change
     * When creating a company, a contact is not explicitly created,
     * the creation date is also automatically added
     */
    public Company() {
        this.country = "ROSSIA";
        this.contactId = new ArrayList<>();

        LocalDateTime data = LocalDateTime.now();
        this.creation = data;
        this.update = data;

    }

    public void addContact(Contact contact) {
        this.contactId.add(contact);
    }

    /**
     * Типы компании, которые можно выбрать при заполнении карточки
     * Company types that can be selected when filling out the card
     */
    public enum CompanyType {
        CLIENT, COMPETITOR, SUPPLIER
    }
}

