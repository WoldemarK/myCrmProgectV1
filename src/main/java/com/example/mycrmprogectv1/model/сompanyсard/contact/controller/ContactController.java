package com.example.mycrmprogectv1.model.сompanyсard.contact.controller;

import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;
import com.example.mycrmprogectv1.model.сompanyсard.contact.repository.ContactRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {

    public final ContactRepositoryImpl service;

    @PostMapping
    public void save(@RequestBody Contact contact) throws SQLException {
        this.service.save(contact);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllCompany() throws SQLException {
        return ResponseEntity.ok(this.service.getAllContact());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws SQLException {
        this.service.delete(id);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<Optional<Contact>> getId(@PathVariable Long id) throws SQLException {
        return ResponseEntity.ok(this.service.findById(id));
    }
    @GetMapping("/getName")
    public ResponseEntity<Optional<Contact>> getName(@RequestParam String name) throws SQLException {
        return ResponseEntity.ok(this.service.findByName(name));
    }



}
