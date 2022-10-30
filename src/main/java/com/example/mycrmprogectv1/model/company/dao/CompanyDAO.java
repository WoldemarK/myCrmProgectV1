package com.example.mycrmprogectv1.model.company.dao;
import com.example.mycrmprogectv1.model.company.Company;

import java.sql.SQLException;
import java.util.List;

public interface CompanyDAO {

    void save(Company company) throws SQLException;

    Company findById(Long id)throws SQLException;

    Company findByName(String nameCompany)throws SQLException;

    Company findByCompanyTyp(Company.Type type);

    List<Company> findByAllCompany() throws SQLException;

    void update(int id, Company company) throws SQLException;

    void delete(int id)throws SQLException;


}
