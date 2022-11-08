package com.example.mycrmprogectv1.model.company.dao.contact.dao;

import com.example.mycrmprogectv1.model.company.dao.contact.Contact;
import com.example.mycrmprogectv1.model.company.dao.contact.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
        jdbcTemplate.update("insert into contact(name,surname,phoneNumber," +
                        "city,country,address,email" +
                        ",postOn,companyId,post)" +
                        "values (?,?,?,?,?,?,?,?,?,?)",
                contact.getName(),
                contact.getSurname(),
                contact.getPhoneNumber(),
                contact.getCity(),
                contact.getAddress(),
                contact.getCompanyId(),
                contact.getEmail(),
                contact.getPost(),
                contact.getPost(),
                contact.getContactId(),
                contact.getPostOn());

    }

    @Override
    public Contact findById(Long contactId) throws SQLException {
        return jdbcTemplate.query("select *from contact where contactId=?",
                        new Object[]{contactId},
                        new BeanPropertyRowMapper<>(Contact.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public Contact findByName(String name) throws SQLException {
        return jdbcTemplate.query("select *from contact where name=?",
                        new Object[]{name},
                        new BeanPropertyRowMapper<>(Contact.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public Contact findByPhoneNumber(String phoneNumber) throws SQLException {
        return jdbcTemplate.query("select *from contact where phoneNumber=?",
                        new Object[]{phoneNumber},
                        new BeanPropertyRowMapper<>(Contact.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Contact> getAllContact() throws SQLException {
        return jdbcTemplate.query("select * from contact " +
                        "join company c on c.companyid = contact.companyid",
                new ContactMapper());
    }

    @Override
    public void findByContactAndCompany() throws SQLException {

    }



    @Override
    public void update(Long contactId, Contact contact) throws SQLException {
        jdbcTemplate.update("update contact set " +
                        "name=?," +
                        "surname=?," +
                        "phoneNumber=?," +
                        "city=?," +
                        "country=?," +
                        "address=?," +
                        "email=?," +
                        "postOn=?," +
                        "companyId=?," +
                        "post=? where contactId=?",
                contact.getName(),
                contact.getSurname(),
                contact.getPhoneNumber(),
                contact.getCity(),
                contact.getAddress(),
                contact.getCompanyId(),
                contact.getEmail(),
                contact.getPost(),
                contact.getPost(),
                contact.getContactId(),
                contact.getPostOn(), contactId);
    }

    @Override
    public void delete(Long contactId) throws SQLException {
        jdbcTemplate.update("delete from contact where contactId=?", contactId);
    }
}