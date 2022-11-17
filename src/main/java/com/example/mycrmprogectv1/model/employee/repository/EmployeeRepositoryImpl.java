package com.example.mycrmprogectv1.model.employee.repository;

import com.example.mycrmprogectv1.model.employee.Employee;
import com.example.mycrmprogectv1.model.employee.mapper.EmpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;
    private static String INSET = "insert into employee,name,surname,phoneNumber,city,country,address,email,post,age,creation,updat) " +
            "values (?,?,?,?,?,?,?,?,?,?,?)";
    private static String SELECT_BY_ID = "select * from employee where Id=?";
    private static String SELECT_BY_NAME = "select * from employee where name=?";
    private static String DELETE = "delete from employee where Id=?";
    private static String GET_ALL = "select * from employee";

    public Employee save(Employee employee) throws SQLException {
        jdbcTemplate.update(INSET,
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
        return employee;
    }


    public Optional<Employee> findByName(String name) throws SQLException {
        List<Employee> results = jdbcTemplate.query(SELECT_BY_NAME, new EmpMapper(), name);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }


    public Optional<Employee> findById(Long Id) throws SQLException {
        List<Employee> results = jdbcTemplate.query(SELECT_BY_ID, new EmpMapper(), Id);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    public void delete(Long Id) throws SQLException {
        jdbcTemplate.update(DELETE, Id);
    }


    public List<Employee> getAll() {
        return jdbcTemplate.query(GET_ALL, new EmpMapper());
    }
}
