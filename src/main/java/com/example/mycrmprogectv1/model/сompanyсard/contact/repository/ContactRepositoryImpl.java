package com.example.mycrmprogectv1.model.сompanyсard.contact.repository;

import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;
import com.example.mycrmprogectv1.model.сompanyсard.contact.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ContactRepositoryImpl implements ContactRepository {
    private final JdbcTemplate jdbcTemplate;
    private static String INSET = "insert into contact, name, surname,phoneNumber,email,post,comment, creation,update) values (?,?,?,?,?,?,?,?)";
    private static String SELECT_BY_ID = "select * from contact where Id=?";
    private static String SELECT_BY_NAME = "select * from contact where name=?";
    private static String DELETE = "delete from contact where id=?";
    private static String GET_ALL = "select * from contact";

    public Contact save(Contact contact) throws SQLException {
        jdbcTemplate.update(INSET,
                contact.getName(),
                contact.getSurname(),
                contact.getPhoneNumber(),
                contact.getEmail(),
                contact.getPost(),
                contact.getComment(),
                contact.getCreation(),
                contact.getUpdate());
        return contact;
    }

    public void delete(Long id) throws SQLException {
        jdbcTemplate.update(DELETE, id);
    }


    public Optional<Contact> findById(Long Id) throws SQLException {
        List<Contact> results = jdbcTemplate.query(SELECT_BY_ID, new ContactMapper(), Id);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));

    }

    public Optional<Contact> findByName(String name) throws SQLException {
        List<Contact> results = jdbcTemplate.query(SELECT_BY_NAME, new ContactMapper(), name);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }


    public List<Contact> getAllContact() throws SQLException {
        return jdbcTemplate.query(GET_ALL, new ContactMapper());
    }

}
