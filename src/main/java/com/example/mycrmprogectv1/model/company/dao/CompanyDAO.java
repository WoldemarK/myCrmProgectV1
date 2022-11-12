package com.example.mycrmprogectv1.model.company.dao;
import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.task.Task;

import java.sql.SQLException;
import java.util.List;

public interface CompanyDAO {

    void save(Company company) throws SQLException;

    Company findById(Long id)throws SQLException;

    Company findByName(String nameCompany)throws SQLException;

    List<Company> getAllCompany() throws SQLException;

    void update(Long id, Company company) throws SQLException;

    void delete(Long id)throws SQLException;


}
