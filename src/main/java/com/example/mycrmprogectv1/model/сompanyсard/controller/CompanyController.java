package com.example.mycrmprogectv1.model.сompanyсard.controller;

import com.example.mycrmprogectv1.model.сompanyсard.Company;
import com.example.mycrmprogectv1.model.сompanyсard.dao.CompanyDAO;
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
        this.companyDAO.save(company);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany() throws SQLException {
        return ResponseEntity.ok(this.companyDAO.getInformationCompanyAndContact());
    }

    @PutMapping("put/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Company company) throws SQLException {
        this.companyDAO.update(id, company);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws SQLException {
        this.companyDAO.delete(id);
    }

    @GetMapping("/id/{id}")
    private ResponseEntity<Company> finById(@PathVariable Long id) throws SQLException {
        return ResponseEntity.ok(companyDAO.findById(id));
    }

    @GetMapping("/name/{name}")
    private ResponseEntity<Company> finByName(@RequestParam String name) throws SQLException {
        return ResponseEntity.ok(companyDAO.findByName(name));
    }
}
