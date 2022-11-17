package com.example.mycrmprogectv1.model.сompanyсard.contact.repository;

import com.example.mycrmprogectv1.model.employee.Employee;
import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;

import java.sql.SQLException;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {

    Contact save(Contact contact) throws SQLException;
    Optional<Contact> findById(Long id)throws SQLException;
    Optional<Contact> findByName(String name)throws SQLException;
    List<Contact> getAllContact() throws SQLException;
    void delete(Long id)throws SQLException;



}
