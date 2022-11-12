package com.example.mycrmprogectv1.model.contact.controller;

import com.example.mycrmprogectv1.model.contact.Contact;
import com.example.mycrmprogectv1.model.contact.dao.ContactDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {

    public final ContactDAO contactDAO;

    @PostMapping
    public void save(@RequestBody Contact contact) throws SQLException {
        this.contactDAO.save(contact);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllCompany() throws SQLException {
        return ResponseEntity.ok(this.contactDAO.getAllContact());
    }

    @PutMapping
    public void update(Long id, Contact contact) throws SQLException {
        this.contactDAO.update(id, contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws SQLException {
        this.contactDAO.delete(id);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Contact> finById(@PathVariable Long Id) throws SQLException {
        return ResponseEntity.ok(contactDAO.findById(Id));
    }

    @GetMapping("/{name}")
    private ResponseEntity<Contact> finByName(@RequestParam String name) throws SQLException {
        return ResponseEntity.ok(contactDAO.findByName(name));
    }

}
