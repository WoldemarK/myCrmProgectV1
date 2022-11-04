package com.example.mycrmprogectv1.model.contact.controller;

import com.example.mycrmprogectv1.model.contact.Contact;
import com.example.mycrmprogectv1.model.contact.dao.ContactDAO;
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

    private final ContactDAO contactDAO;

    @GetMapping
    public ResponseEntity<List<Contact>>getAllContact() throws SQLException {
        return ResponseEntity.ok(contactDAO.findByAllContact());
    }
}
