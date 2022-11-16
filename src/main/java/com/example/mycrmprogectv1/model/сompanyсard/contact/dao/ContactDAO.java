package com.example.mycrmprogectv1.model.сompanyсard.contact.dao;
import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
@Component
public interface ContactDAO {

    void save(Contact contact) throws SQLException;
    Contact findById(Long contactId)throws SQLException;
    Contact findByName(String name)throws SQLException;
    List<Contact> getAllContact() throws SQLException;
    void update(Long contactId, Contact contact) throws SQLException;
    void delete(Long contactId)throws SQLException;


}
