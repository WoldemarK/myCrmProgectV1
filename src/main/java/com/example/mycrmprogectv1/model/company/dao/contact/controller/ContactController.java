package com.example.mycrmprogectv1.model.company.dao.contact.controller;

import com.example.mycrmprogectv1.model.company.dao.contact.Contact;
import com.example.mycrmprogectv1.model.company.dao.contact.dao.ContactDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {

    public final ContactDAO contactDAO;

    @GetMapping
    public ResponseEntity<List<Contact>>getAllContact() throws SQLException {
        return ResponseEntity.ok(contactDAO.getAllContact());
    }
}
