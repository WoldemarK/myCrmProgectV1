package com.example.mycrmprogectv1.model.employee.dao;

import com.example.mycrmprogectv1.model.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void save(Employee employee) throws SQLException;

    Employee getName(String name) throws SQLException;

    Employee getById(Long id) throws SQLException;

    Employee findByPhoneNumber(String phoneNumber) throws SQLException;

    void update(Long id, Employee employee) throws SQLException;

    void delete(Long id) throws SQLException;

    Employee getByTypePost(Employee.TypePost typePost);

    List<Employee>getAllEmployee();

}
