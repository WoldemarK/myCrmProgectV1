package com.example.mycrmprogectv1.model.contact.mapper;

import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.contact.Contact;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setContactId(rs.getLong("contactId"));
        contact.setName(rs.getString("name"));
        contact.setSurname(rs.getString("surname"));
        contact.setPhoneNumber(rs.getString("phoneNumber"));
        contact.setCity(rs.getString("city"));
        contact.setCountry(rs.getString("country"));
        contact.setAddress(rs.getString("address"));
        contact.setEmail(rs.getString("email"));
        contact.setPost(rs.getString("post"));

//        Company company = new Company();
//        company.setCompanyId(rs.getLong("companyId"));
//        company.setName(rs.getString("name"));
//        company.setPhoneNumber(rs.getString("phoneNumber"));
//        company.setCity(rs.getString("city"));
//        company.setCountry(rs.getString("country"));
//        company.setAddress(rs.getString("address"));
//        company.setEmail(rs.getString("email"));
//        company.setWebsite(rs.getString("website"));
//        company.setComment(rs.getString("comment"));
//        company.setCreation(rs.getTimestamp("creation").toLocalDateTime());
//        company.setCompanyId(rs.getLong("contactId"));

       // contact.setCompanyId(company);

        return contact;
    }
}