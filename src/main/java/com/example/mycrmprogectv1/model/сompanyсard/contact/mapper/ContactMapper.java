package com.example.mycrmprogectv1.model.сompanyсard.contact.mapper;

import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class ContactMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {

        Contact contact = new Contact();

        contact.setId(rs.getLong("Id"));
        contact.setName(rs.getString("name"));
        contact.setSurname(rs.getString("surname"));
        contact.setPhoneNumber(rs.getString("phoneNumber"));
        contact.setEmail(rs.getString("email"));
        contact.setPost(rs.getString("post"));
        contact.setComment(rs.getString("comment"));
        contact.setCreation(rs.getTimestamp("creation").toLocalDateTime());
        contact.setUpdate(rs.getTimestamp("update").toLocalDateTime());

        return contact;

    }
}
