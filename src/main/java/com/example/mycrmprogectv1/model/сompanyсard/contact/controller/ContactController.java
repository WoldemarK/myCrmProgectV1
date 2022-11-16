package com.example.mycrmprogectv1.model.сompanyсard.contact.controller;

import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;
import com.example.mycrmprogectv1.model.сompanyсard.contact.dao.ContactDAO;
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

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllCompany() throws SQLException {
        return ResponseEntity.ok(this.contactDAO.getAllContact());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws SQLException {
        this.contactDAO.delete(id);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Contact> finById(@PathVariable Long id) throws SQLException {
        return ResponseEntity.ok(contactDAO.findById(id));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Contact> finById(@RequestParam String name) throws SQLException {
        return ResponseEntity.ok(contactDAO.findByName(name));
    }

    @PutMapping(value = "/put{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Contact contact) throws SQLException {
        this.contactDAO.update(id, contact);
    }




    @GetMapping("/{name}")
    private ResponseEntity<Contact> finByName(@RequestParam String name) throws SQLException {
        return ResponseEntity.ok(contactDAO.findByName(name));
    }

}
