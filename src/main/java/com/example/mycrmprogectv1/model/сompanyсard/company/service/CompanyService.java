package com.example.mycrmprogectv1.model.сompanyсard.company.service;

import com.example.mycrmprogectv1.model.сompanyсard.company.Company;
import com.example.mycrmprogectv1.model.сompanyсard.company.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final JdbcTemplate jdbcTemplate;

    public void save(Company company) throws SQLException {
        jdbcTemplate.update("insert into company" +
                        "(" +
                        "name," +
                        "phonenumber, " +
                        "city, " +
                        "country, " +
                        "address, " +
                        "email," +
                        "website, " +
                        "comment," +
                        "creation," +
                        "update," +
                        "typeCompany" +
                        ") " +
                        "values(?,?,?,?,?,?,?,?,?,?,?)",
                company.getName(),
                company.getPhoneNumber(),
                company.getCity(),
                company.getCountry(),
                company.getAddress(),
                company.getEmail(),
                company.getWebsite(),
                company.getComment(),
                company.getCreation(),
                company.getUpdate(),
                company.getTypeCompany()

        );
    }


    public Company findById(Long Id) throws SQLException {
        return jdbcTemplate.query("select * from company where Id=?",
                        new Object[]{Id},
                        new CompanyMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    public Company findByName(String name) throws SQLException {
        return jdbcTemplate.query("select * from company where name=?",
                        new Object[]{name},
                        new CompanyMapper())
                .stream()
                .findAny()
                .orElse(null);
    }


    public void delete(Long Id) throws SQLException {
        jdbcTemplate.update("delete from company where Id=?", Id);
    }

    public List<Company> getAll() {
       return jdbcTemplate.query("select * from company",new CompanyMapper());
    }
}
