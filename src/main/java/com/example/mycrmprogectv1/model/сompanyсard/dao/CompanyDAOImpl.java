package com.example.mycrmprogectv1.model.сompanyсard.dao;

import com.example.mycrmprogectv1.model.сompanyсard.Company;
import com.example.mycrmprogectv1.model.сompanyсard.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
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
                        "typeCompany" +
                        "creation," +
                        "contactId" +
                        "companyType" +

                        ") " +
                        "values(?,?,?,?,?,?,?,?,?,?,?,?)",
                company.getName(),
                company.getPhoneNumber(),
                company.getCity(),
                company.getCountry(),
                company.getAddress(),
                company.getEmail(),
                company.getWebsite(),
                company.getComment(),
                company.getTypeCompany(),
                company.getContactId(),
                company.getCompanyType()
        );
    }

    @Override
    public Company findById(Long companyId) throws SQLException {
        return jdbcTemplate.query("select * from company where companyId=?",
                        new Object[]{companyId},
                        new CompanyMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public Company findByName(String name) throws SQLException {
        return jdbcTemplate.query("select * from company where name=?",
                        new Object[]{name},
                        new CompanyMapper())
                .stream()
                .findAny()
                .orElse(null);
    }


    @Override
    public List<Company> getInformationCompanyAndContact() {
        return jdbcTemplate.query("select * from company " +
                        "join contact c on c.contactid = company.contactid",
                new CompanyMapper());
    }

    @Override
    public void update(Long companyId, Company company) throws SQLException {
        jdbcTemplate.update("update company set " +
                        "name=?, " +
                        "phonenumber=? ," +
                        "city=?," +
                        "country=?," +
                        "address=?," +
                        "email=?," +
                        "website=?," +
                        "comment=?, " +
                        "typeCompany=?," +
                        "contactId," +
                        "companyType," +
                        "WHERE companyId=?",
                company.getName(),
                company.getPhoneNumber(),
                company.getCity(),
                company.getCountry(),
                company.getAddress(),
                company.getEmail(),
                company.getWebsite(),
                company.getComment(),
                company.getTypeCompany(),
                company.getContactId(),
                company.getCompanyType(), companyId);
    }

    @Override
    public void delete(Long companyId) throws SQLException {
        jdbcTemplate.update("delete from company where companyId=?", companyId);
    }
}
