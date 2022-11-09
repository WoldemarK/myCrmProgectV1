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
        jdbcTemplate.update("insert into employee values (?,?,?,?,?,?,?,?,?,?,?,?)");
    }

    @Override
    public Employee getName(String name) throws SQLException {
        return jdbcTemplate.query("select * from employee where name=?",
                new Object[]{name},
                new EmpMapper()).stream().findAny().orElse(null);
    }

    @Override
    public Employee getById(Long taskId) throws SQLException {
        return jdbcTemplate.query("select * from employee where taskId=?",
                new Object[]{taskId},
                new EmpMapper()).stream().findAny().orElse(null);
    }

    @Override
    public Employee findByPhoneNumber(String phoneNumber) throws SQLException {
        return jdbcTemplate.query("select * from employee where phoneNumber=?",
                new Object[]{phoneNumber},
                new EmpMapper()).stream().findAny().orElse(null);
    }

    @Override
    public void update(Long employeeId, Employee employee) throws SQLException {

    }

    @Override
    public void delete(Long employeeId) throws SQLException {
        jdbcTemplate.update("delete from employee where employeeId=?", employeeId);
    }

    @Override
    public Employee getByTypePost(Employee.TypePost typePost) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return jdbcTemplate.query("select * from employee " + "" +
                "join company c on c.companyid = employee.companyid", new EmpMapper());
    }
}
