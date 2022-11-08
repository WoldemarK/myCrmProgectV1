package com.example.mycrmprogectv1.model.employee.controller;

import com.example.mycrmprogectv1.model.employee.Employee;
import com.example.mycrmprogectv1.model.employee.dao.EmployeeDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
