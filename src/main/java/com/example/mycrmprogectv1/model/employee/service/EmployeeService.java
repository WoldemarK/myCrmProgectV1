package com.example.mycrmprogectv1.model.employee.service;

import com.example.mycrmprogectv1.model.employee.Employee;
import com.example.mycrmprogectv1.model.employee.mapper.EmpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeService {
    private final JdbcTemplate jdbcTemplate;

    public void save(Employee employee) throws SQLException {
        jdbcTemplate.update("insert into employee " +
                        "(" +
                        "name," +
                        "surname," +
                        "phoneNumber," +
                        "city," +
                        "country," +
                        "address," +
                        "email," +
                        "post," +
                        "age," +
                        "creation," +
                        "update" +
                        ") " +
                        "values (?,?,?,?,?,?,?,?,?,?,?)",
                employee.getName(),
                employee.getSurname(),
                employee.getPhoneNumber(),
                employee.getCity(),
                employee.getCountry(),
                employee.getAddress(),
                employee.getEmail(),
                employee.getPost(),
                employee.getAge(),
                employee.getCreation(),
                employee.getUpdate());
    }


    public Employee findByName(String name) throws SQLException {
        return jdbcTemplate.query("select * from employee where name=?",
                        new Object[]{name},
                        new EmpMapper())
                .stream()
                .findAny()
                .orElse(null);
    }


    public Employee findById(Long Id) throws SQLException {
        return jdbcTemplate.query("select * from employee where Id=?",
                        new Object[]{Id},
                        new EmpMapper())
                .stream()
                .findAny()
                .orElse(null);
    }




    public void delete(Long Id) throws SQLException {
        jdbcTemplate.update("delete from employee where Id=?", Id);
    }


    public List<Employee> getAll() {
        return jdbcTemplate.query("select * from employee ", new EmpMapper());
    }
}
