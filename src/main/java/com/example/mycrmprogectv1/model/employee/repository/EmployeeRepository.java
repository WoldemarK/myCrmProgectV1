package com.example.mycrmprogectv1.model.employee.repository;

import com.example.mycrmprogectv1.model.employee.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Employee save(Employee employee) throws SQLException;

    Optional<Employee> findByName(String name) throws SQLException;

    Optional<Employee> findById(Long id) throws SQLException;

    void delete(Long id) throws SQLException;

    List<Employee> getAll();

}
