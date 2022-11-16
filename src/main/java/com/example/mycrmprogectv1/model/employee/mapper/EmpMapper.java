package com.example.mycrmprogectv1.model.employee.mapper;

import com.example.mycrmprogectv1.model.сompanyсard.company.Company;
import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;
import com.example.mycrmprogectv1.model.employee.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

        Employee employee = new Employee();
        employee.setId(rs.getLong("Id"));
        employee.setName(rs.getString("name"));
        employee.setSurname(rs.getString("surname"));
        employee.setPhoneNumber(rs.getString("phoneNumber"));
        employee.setCity(rs.getString("city"));
        employee.setCountry(rs.getString("country"));
        employee.setAddress(rs.getString("address"));
        employee.setEmail(rs.getString("email"));
        employee.setPost(rs.getString("post"));
        employee.setAge(rs.getLong("age"));
        employee.setCreation(rs.getTimestamp("creation").toLocalDateTime());
        employee.setUpdate(rs.getTimestamp("update").toLocalDateTime());


//        Company company = new Company();
//        company.setId(rs.getLong("Id"));
//        company.setName(rs.getString("name"));
//        company.setPhoneNumber(rs.getString("phoneNumber"));
//        company.setCity(rs.getString("city"));
//        company.setCountry(rs.getString("country"));
//        company.setAddress(rs.getString("address"));
//        company.setEmail(rs.getString("email"));
//        company.setWebsite(rs.getString("website"));
//        company.setComment(rs.getString("comment"));
//        company.setCreation(rs.getTimestamp("creation").toLocalDateTime());
//        company.setUpdate(rs.getTimestamp("update").toLocalDateTime());
//        company.setTypeCompany(rs.getString("typeCompany"));
//
//
//        Contact contact = new Contact();
//        contact.setId(rs.getLong("Id"));
//        contact.setName(rs.getString("name"));
//        contact.setSurname(rs.getString("surname"));
//        contact.setPhoneNumber(rs.getString("phoneNumber"));
//        contact.setEmail(rs.getString("email"));
//        contact.setPost(rs.getString("post"));
//        contact.setComment(rs.getString("comment"));
//        contact.setCreation(rs.getTimestamp("creation").toLocalDateTime());
//        contact.setUpdate(rs.getTimestamp("update").toLocalDateTime());

        return employee;
    }
}
