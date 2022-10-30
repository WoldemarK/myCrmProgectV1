package com.example.mycrmprogectv1.model.contact.dao;
import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.contact.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ContactDAOImpl implements ContactDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Contact contact) throws SQLException {

    }

    @Override
    public Contact findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public Contact findByName(String nameContact) throws SQLException {
        return null;
    }

    @Override
    public Company findByPhoneNumber(String phoneNumber) throws SQLException {
        return null;
    }

    @Override
    public List<Contact> findByAllContact() throws SQLException {
        return null;
    }

    @Override
    public Contact findByCompany(Company company) throws SQLException {
        return null;
    }

    @Override
    public void update(int id, Contact contact) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
