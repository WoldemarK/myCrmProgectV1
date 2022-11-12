package com.example.mycrmprogectv1.model.employee.controller;

import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.employee.Employee;
import com.example.mycrmprogectv1.model.employee.dao.EmployeeDAOImpl;
import com.example.mycrmprogectv1.model.employee.mapper.EmpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeDAOImpl employeeDAO;

    @GetMapping
    public ResponseEntity<List<Employee>>getAll(){
        return ResponseEntity.ok(employeeDAO.getAllEmployee());
    }
    @PostMapping
    public void save(@RequestBody Employee employee) throws SQLException {
        employeeDAO.save(employee);
    }

    @PutMapping
    public void update(Long id,  Employee employee) throws SQLException {
        this.employeeDAO.update(id, employee);
    }
    @DeleteMapping
    public void delete(Long id) throws SQLException {
        this.employeeDAO.delete(id);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Employee> finById(@PathVariable Long id) throws SQLException {
        return ResponseEntity.ok(employeeDAO.findById(id));
    }
    @GetMapping("/{name}")
    private ResponseEntity<Employee>finByName(@RequestParam String name) throws SQLException{
        return ResponseEntity.ok(employeeDAO.findByName(name));
    }
}
