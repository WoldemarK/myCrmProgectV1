package com.example.mycrmprogectv1.model.сompanyсard.contact.service;

import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;
import com.example.mycrmprogectv1.model.сompanyсard.contact.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final JdbcTemplate jdbcTemplate;

    public void save(Contact contact) throws SQLException {
        jdbcTemplate.update("insert into contact" +
                        "(" +
                        "name, " +
                        "surname," +
                        "phoneNumber," +
                        "email,post," +
                        "comment, " +
                        "creation," +
                        "update" +
                        ") " +
                        "values (?,?,?,?,?,?,?,?)",
                contact.getName(),
                contact.getSurname(),
                contact.getPhoneNumber(),
                contact.getEmail(),
                contact.getPost(),
                contact.getComment(),
                contact.getCreation(),
                contact.getUpdate());
    }

    public void delete(Long id) throws SQLException {
        jdbcTemplate.update("delete from contact where id=?", id);
    }


    public Contact findById(Long Id) throws SQLException {
        return jdbcTemplate.query("select * from contact where Id=?",
                        new Object[]{Id},
                        new ContactMapper())
                .stream()
                .findAny()
                /*
                .orElse(null); так делать нельзя уточнить как можно
                 */
                .orElse(null);
    }

    public Contact findByName(String name) throws SQLException {
        return jdbcTemplate.query("select * from contact where name=?",
                        new Object[]{name},
                        new ContactMapper())
                .stream()
                .findAny()
                /*
                  .orElse(null); так делать нельзя уточнить как можно
               */
                .orElse(null);
    }


    public List<Contact> getAllContact() throws SQLException {
        return jdbcTemplate.query("select * from contact ", new ContactMapper());
    }

}
