package com.example.mycrmprogectv1.model.employee.controller;

import com.example.mycrmprogectv1.model.employee.Employee;

import com.example.mycrmprogectv1.model.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>>getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping
    public void save(@RequestBody Employee employee) throws SQLException {
        service.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws SQLException {
        this.service.delete(id);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Employee> finById(@PathVariable Long id) throws SQLException {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/getName")
    private ResponseEntity<Employee>finByName(@RequestParam String name) throws SQLException{
        return ResponseEntity.ok(service.findByName(name));
    }
}
