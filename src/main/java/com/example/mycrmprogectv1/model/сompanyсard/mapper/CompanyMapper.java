package com.example.mycrmprogectv1.model.сompanyсard.mapper;

import com.example.mycrmprogectv1.model.сompanyсard.Company;
import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMapper implements RowMapper<Company> {
    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {

        Company company = new Company();
        company.setCompanyId(rs.getLong("companyId"));
        company.setName(rs.getString("name"));
        company.setPhoneNumber(rs.getString("phoneNumber"));
        company.setCity(rs.getString("city"));
        company.setCountry(rs.getString("country"));
        company.setAddress(rs.getString("address"));
        company.setEmail(rs.getString("email"));
        company.setWebsite(rs.getString("website"));
        company.setComment(rs.getString("comment"));
        company.setCreation(rs.getTimestamp("creation").toLocalDateTime());
        company.setCompanyId(rs.getLong("contactId"));
        company.setCompanyType(Company.CompanyType.valueOf(rs.getString("contactTypePost")));

        Contact contact = new Contact();
        contact.setContactId(rs.getLong("contactId"));
        contact.setName(rs.getString("name"));
        contact.setSurname(rs.getString("surname"));
        contact.setPhoneNumber(rs.getString("phoneNumber"));
        contact.setEmail(rs.getString("email"));
        contact.setPost(rs.getString("post"));
        contact.setContactTypePost(Contact.ContactTypePost.valueOf(rs.getString("contactTypePost")));

        company.setContactId(contact);
        return company;
    }
}
