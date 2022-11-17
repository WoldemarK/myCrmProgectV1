package com.example.mycrmprogectv1.model.сompanyсard.company.controller;

import com.example.mycrmprogectv1.model.сompanyсard.company.Company;
import com.example.mycrmprogectv1.model.сompanyсard.company.repository.CompanyRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/com")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyRepositoryImpl service;

    @PostMapping
    public void save(@RequestBody Company company) throws SQLException {
        this.service.save(company);
    }

    @GetMapping
    public ResponseEntity<Optional<Company>> getAllCompany() throws SQLException {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/getId/{id}")
    private ResponseEntity<Optional<Company>> finById(@PathVariable Long id) throws SQLException {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws SQLException {
        this.service.delete(id);
    }

    @GetMapping("/getName")
    private ResponseEntity<Optional<Company>> finByName(@RequestParam String name) throws SQLException {
        return ResponseEntity.ok(service.findByName(name));
    }
}
