package com.example.mycrmprogectv1.model.company.controller;

import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.company.dao.CompanyDAO;
import com.example.mycrmprogectv1.model.task.Task;
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
        return ResponseEntity.ok(this.companyDAO.getAllCompany());
    }
    @PutMapping
    public void update(Long id, Company company) throws SQLException {
        this.companyDAO.update(id, company);
    }
    @DeleteMapping
    public void delete(Long id) throws SQLException {
        this.companyDAO.delete(id);
    }
    @GetMapping("/get/{id}")
    private ResponseEntity<Company> finById(@PathVariable Long id) throws SQLException {
        return ResponseEntity.ok(companyDAO.findById(id));
    }
    @GetMapping("/{name}")
    private ResponseEntity<Company>finByName(@RequestParam String name) throws SQLException{
        return ResponseEntity.ok(companyDAO.findByName(name));
    }
}
