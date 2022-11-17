package com.example.mycrmprogectv1.model.сompanyсard.company.repository;

import com.example.mycrmprogectv1.model.сompanyсard.company.Company;

import java.sql.SQLException;
import java.util.Optional;

public interface CompanyRepository {

    Company save(Company company) throws SQLException;

    Optional<Company> findById(Long id)throws SQLException;

    Optional<Company> findByName(String nameCompany)throws SQLException;


    void delete(Long id)throws SQLException;


}
