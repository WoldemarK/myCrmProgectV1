package com.example.mycrmprogectv1.model.company.dao;

import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.company.mapper.CompanyMapper;
import com.example.mycrmprogectv1.model.task.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompanyDAOImpl implements CompanyDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Company company) throws SQLException {
        jdbcTemplate.update("insert into company(name,phone_number, city, country, " +
                        "address, email, website, comment,creation,contact_Id) " +
                        "values(?,?,?,?,?,?,?,?,?,?,?)",
                company.getName(),
                company.getPhoneNumber(),
                company.getCity(),
                company.getCountry(),
                company.getAddress(),
                company.getEmail(),
                company.getWebsite(),
                company.getComment(),
                company.getContactId(),
                company.getCreation());
    }

    @Override
    public Company findById(Long companyId) throws SQLException {
        return (Company) jdbcTemplate.query("select * from company where companyId=?",
                        new Object[]{companyId},new TaskMapper());

    }

    @Override
    public Company findByName(String name) throws SQLException {
        return jdbcTemplate.query("select * from company where name=?",
                        new Object[]{name},
                        new BeanPropertyRowMapper<>(Company.class))
                .stream()
                .findAny()
                .orElse(null);
    }


    @Override
    public List<Company> getAllCompany() throws SQLException {
        return jdbcTemplate.query("select * from company " +
                        "join contact c on c.contact_id = company.contact_id",
                new CompanyMapper());
    }

    @Override
    public void update(Long companyId, Company company) throws SQLException {
        jdbcTemplate.update("update company set name=?, phone_number=? ," +
                        "city=?,country=?,address=?,email=? ,website=?,comment=?, " +
                        "contact_Id=?,creation=? WHERE companyId=?",
                company.getName(),
                company.getPhoneNumber(),
                company.getCity(),
                company.getCountry(),
                company.getAddress(),
                company.getEmail(),
                company.getWebsite(),
                company.getComment(),
                company.getContactId(),
                company.getCreation(), companyId);
    }

    @Override
    public void delete(Long companyId) throws SQLException {
        jdbcTemplate.update("delete from company where companyId=?", companyId);
    }
}
