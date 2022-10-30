package com.example.mycrmprogectv1.model.contact.dao;

import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.contact.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
        jdbcTemplate.update("insert into concat(name,surname,phoneNumber," +
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
    public Contact findById(Long id) throws SQLException {
        return jdbcTemplate.query("select *from contact where id=?",
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Contact.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public Contact findByName(String nameContact) throws SQLException {
        return jdbcTemplate.query("select *from contact where nameContact=?",
                        new Object[]{nameContact},
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
    public List<Contact> findByAllContact() throws SQLException {
        return jdbcTemplate.query("select * from contact",
                new BeanPropertyRowMapper<>(Contact.class));
    }

    /**
     * Нужен Mapper-?
     *
     * @throws SQLException
     */
    @Override
    public void findByCompanyAndContact() throws SQLException {
        return jdbcTemplate
                .query("select * from contact left join company on contact_id = company_id");
    }

    @Override
    public void update(int id, Contact contact) throws SQLException {
        jdbcTemplate.update("update concat set " +
                        "name=?," +
                        "surname=?," +
                        "phoneNumber=?," +
                        "city=?," +
                        "country=?," +
                        "address=?," +
                        "email=?," +
                        "postOn=?," +
                        "companyId=?," +
                        "post=? where id=?",
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
                contact.getPostOn(), id);
    }

    @Override
    public void delete(int id) throws SQLException {
        jdbcTemplate.update("delete from contact where id=?", id);
    }
}
