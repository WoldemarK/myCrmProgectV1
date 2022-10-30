package com.example.mycrmprogectv1.model.contact.controller;

import com.example.mycrmprogectv1.model.contact.dao.ContactDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactDAO contactDAO;
}
