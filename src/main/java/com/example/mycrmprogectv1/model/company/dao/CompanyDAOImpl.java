package com.example.mycrmprogectv1.model.company.dao;

import com.example.mycrmprogectv1.model.company.Company;
import lombok.RequiredArgsConstructor;
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
        jdbcTemplate.update("insert into company(name,phonenumber, city, country, address,email, website, comment," +
                "typecompany) values (:name, :phonenumber, :city, :country, :address, :email, :website, :comment, :typecompany)");

    }

    @Override
    public Company findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public Company findByName(String nameCompany) throws SQLException {
        return null;
    }

    @Override
    public Company findByCompanyTyp(Company.Type type) {
        return null;
    }

    @Override
    public List<Company> findByAllCompany() throws SQLException {
        return null;
    }

    @Override
    public void update(int id, Company company) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
