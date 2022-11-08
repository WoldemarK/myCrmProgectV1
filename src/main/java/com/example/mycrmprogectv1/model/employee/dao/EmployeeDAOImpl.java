package com.example.mycrmprogectv1.model.employee.dao;

import com.example.mycrmprogectv1.model.employee.Employee;
import com.example.mycrmprogectv1.model.employee.mapper.EmpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDAOImpl implements EmployeeDAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Employee employee) throws SQLException {

    }

    @Override
    public Employee getName(String name) throws SQLException {
        return null;
    }

    @Override
    public Employee getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public Employee findByPhoneNumber(String phoneNumber) throws SQLException {
        return null;
    }

    @Override
    public void update(int id, Employee employee) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Employee getByTypePost(Employee.TypePost typePost) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return jdbcTemplate.query("select * from employee " +
                "join company c on c.companyid = employee.companyid", new EmpMapper());
    }
}
