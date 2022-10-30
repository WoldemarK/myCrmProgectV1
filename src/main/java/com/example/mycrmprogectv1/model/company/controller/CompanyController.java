package com.example.mycrmprogectv1.model.company.controller;
import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.company.dao.CompanyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
public class CompanyController {

   private final CompanyDAO companyDAO;

    @PostMapping
    public void save(@RequestBody Company company) throws SQLException {
        companyDAO.save(company);
    }
}
