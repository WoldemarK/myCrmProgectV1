package com.example.mycrmprogectv1.model.сompanyсard.contact.dao;

import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;
import com.example.mycrmprogectv1.model.сompanyсard.contact.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContactDAOImpl implements ContactDAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Contact contact) throws SQLException {
        jdbcTemplate.update("insert into contact(name, " +
                        "surname,phoneNumber,email,post,companyId,contactTypePost) " +
                        "values (?,?,?,?,?,?,?)",
                contact.getName(),
                contact.getSurname(),
                contact.getPhoneNumber(),
                contact.getEmail(),
                contact.getPost(),
                contact.getCompanyId(),
                contact.getContactTypePost());

    }

    @Override
    public Contact findById(Long contactId) throws SQLException {
        return jdbcTemplate.query("select * from contact where contactId=?",
                        new Object[]{contactId},
                        new ContactMapper())
                .stream()
                .findAny()
                .orElse(null);
    }


    @Override
    public Contact findByName(String name) throws SQLException {
        return jdbcTemplate.query("select *from contact where name=?",
                        new Object[]{name},
                        new ContactMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Contact> getAllContact() throws SQLException {
        return jdbcTemplate.query("select * from contact ",
                new ContactMapper());
    }


    @Override
    public void update(Long contactId, Contact contact) throws SQLException {
        jdbcTemplate.update("update contact set name=?, surname=?,phoneNumber=?,email=?,post=?,companyId=?,contactTypePost=? where contactId=?" +
                        contact.getName(),
                contact.getSurname(),
                contact.getPhoneNumber(),
                contact.getEmail(),
                contact.getPost(),
                contact.getCompanyId(),
                contact.getContactTypePost());
    }

    @Override
    public void delete(Long contactId) throws SQLException {
        jdbcTemplate.update("delete from contact where contactId=?", contactId);
    }
}
