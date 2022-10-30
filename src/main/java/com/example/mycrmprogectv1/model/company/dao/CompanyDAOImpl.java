package com.example.mycrmprogectv1.model.company.dao;

import com.example.mycrmprogectv1.model.company.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompanyDAOImpl implements CompanyDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Company company) throws SQLException {
        jdbcTemplate.update("insert into company (name, phoneNumber,city,country,address,email " +
                        ",website,comment,contact,typeCompany,creation) " +
                        "values(?,?,?,?,?,?,?,?,?,?,?) ",
                company.getName(),
                company.getPhoneNumber(),
                company.getCity(),
                company.getCountry(),
                company.getAddress(),
                company.getEmail(),
                company.getWebsite(),
                company.getComment(),
                company.getContact(),
                company.getTypeCompany(),
                company.getCreation());
    }

    @Override
    public Company findById(Long id) throws SQLException {
        return jdbcTemplate.query("select *from company where id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Company.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public Company findByName(String nameCompany) throws SQLException {
        return jdbcTemplate.query("select *from company where nameCompany=?",
                        new Object[]{nameCompany},
                        new BeanPropertyRowMapper<>(Company.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public Company findByCompanyTyp(Company.Type type) {
        jdbcTemplate.query("select *from company where type=?",
                        new Object[]{type},
                        new BeanPropertyRowMapper<>(Company.Type.class))
                .stream()
                .findAny();
        return null;
    }

    @Override
    public List<Company> findByAllCompany() throws SQLException {
        return jdbcTemplate.query("select * from company",
                new BeanPropertyRowMapper<>(Company.class));
    }

    @Override
    public void update(int id, Company company) throws SQLException {
        jdbcTemplate.update("update company set name=?, phoneNumber=? ," +
                        "city=?,country=?,address=?,email=? ,website=?,comment=?, " +
                        "contact=?,typeCompany=?,creation=? WHERE id=?",
                company.getName(),
                company.getPhoneNumber(),
                company.getCity(),
                company.getCountry(),
                company.getAddress(),
                company.getEmail(),
                company.getWebsite(),
                company.getComment(),
                company.getContact(),
                company.getTypeCompany(),
                company.getCreation(), id);
    }

    @Override
    public void delete(int id) throws SQLException {
        jdbcTemplate.update("delete from company where id=?", id);
    }
}
