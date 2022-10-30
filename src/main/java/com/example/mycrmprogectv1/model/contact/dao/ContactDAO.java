package com.example.mycrmprogectv1.model.contact.dao;
import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.contact.Contact;

import java.sql.SQLException;
import java.util.List;


public interface ContactDAO {

    void save(Contact contact) throws SQLException;

    Contact findById(Long id)throws SQLException;

    Contact findByName(String nameContact)throws SQLException;

    Contact findByPhoneNumber(String phoneNumber)throws SQLException;

    List<Contact> findByAllContact() throws SQLException;

    void findByContactAndCompany()throws SQLException;

    void update(int id, Contact contact) throws SQLException;

    void delete(int id)throws SQLException;


}
