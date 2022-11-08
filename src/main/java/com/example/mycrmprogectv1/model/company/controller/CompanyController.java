package com.example.mycrmprogectv1.model.company.controller;
import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.company.dao.CompanyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/com")
@RequiredArgsConstructor
public class CompanyController {

   private final CompanyDAO companyDAO;

    @PostMapping
    public void save(@RequestBody Company company) throws SQLException {
        companyDAO.save(company);
    }

    @GetMapping
    public ResponseEntity<List<Company>>getAllCompany() throws SQLException {
        return ResponseEntity.ok(companyDAO.getAllCompany());
    }
}
