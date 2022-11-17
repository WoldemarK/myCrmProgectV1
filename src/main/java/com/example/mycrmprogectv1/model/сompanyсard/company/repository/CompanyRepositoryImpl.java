package com.example.mycrmprogectv1.model.сompanyсard.company.repository;

import com.example.mycrmprogectv1.model.employee.Employee;
import com.example.mycrmprogectv1.model.сompanyсard.company.Company;
import com.example.mycrmprogectv1.model.сompanyсard.company.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator;

@Service
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {
    private final JdbcTemplate jdbcTemplate;
    private static String INSET = "insert into company, name,phonenumber, city,country,address,email, website,comment,creation,update,typeCompany values(?,?,?,?,?,?,?,?,?,?,?)";
    private static String SELECT_BY_ID = "select * from company where Id=?";
    private static String SELECT_BY_NAME = "select * from company where name=?";
    private static String DELETE = "delete from company where Id=?";
    private static String GET_ALL = "select * from company";

    public Company save(Company company) throws SQLException {
        jdbcTemplate.update(INSET,
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
                company.getTypeCompany());
        return company;

    }


    public Optional<Company> findById(Long Id) throws SQLException {
        List<Company> results = jdbcTemplate.query(SELECT_BY_ID, new CompanyMapper(), Id);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    public Optional<Company> findByName(String name) throws SQLException {
        List<Company> results = jdbcTemplate.query(SELECT_BY_NAME, new CompanyMapper(), name);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }


    public void delete(Long Id) throws SQLException {
        jdbcTemplate.update(DELETE, Id);
    }

    public Optional<Company> getAll() {
        List<Company> results = jdbcTemplate.query(GET_ALL, new CompanyMapper());
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }
}
