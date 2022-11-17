package com.example.mycrmprogectv1.model.employee.controller;

import com.example.mycrmprogectv1.model.employee.Employee;

import com.example.mycrmprogectv1.model.employee.repository.EmployeeRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepositoryImpl service;

    @GetMapping
    public ResponseEntity<List<Employee>>getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee) throws SQLException {
        return ResponseEntity.ok(service.save(employee));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws SQLException {
        this.service.delete(id);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Optional<Employee>> finById(@PathVariable Long id) throws SQLException {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/getName")
    private ResponseEntity<Optional<Employee>>finByName(@RequestParam String name) throws SQLException{
        return ResponseEntity.ok(service.findByName(name));
    }
}
