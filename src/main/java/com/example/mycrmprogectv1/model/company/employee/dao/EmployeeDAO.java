package com.example.mycrmprogectv1.model.company.employee.dao;

import com.example.mycrmprogectv1.model.company.employee.Employee;
import com.example.mycrmprogectv1.model.contact.Contact;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void save(Employee employee) throws SQLException;

    Employee getByName(String name) throws SQLException;

    Employee getById(Long id) throws SQLException;

    Employee findByPhoneNumber(String phoneNumber) throws SQLException;

    void update(int id, Employee employee) throws SQLException;

    void delete(int id) throws SQLException;

    Employee getByTypePost(Employee.TypePost typePost);

    List<Employee>getAllEmployee();

}
