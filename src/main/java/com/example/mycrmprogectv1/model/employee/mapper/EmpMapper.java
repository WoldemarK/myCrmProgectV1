package com.example.mycrmprogectv1.model.employee.mapper;

import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.contact.Contact;
import com.example.mycrmprogectv1.model.employee.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

        Employee employee = new Employee();
        employee.setEmployeeId(rs.getLong("employeeId"));
        employee.setName(rs.getString("name"));
        employee.setSurname(rs.getString("surname"));
        employee.setPhoneNumber(rs.getString("phoneNumber"));
        employee.setCity(rs.getString("city"));
        employee.setCountry(rs.getString("country"));
        employee.setAddress(rs.getString("address"));
        employee.setEmail(rs.getString("email"));
        employee.setPostOn(rs.getString("postOn"));
        employee.setAge(rs.getInt("age"));
        // employee.setBirth(rs.getTimestamp("birth"));// LocalDateTime
        employee.setPost(Employee.TypePost.valueOf(rs.getString("post")));

        Company company = new Company();
        company.setCompanyId(rs.getLong("companyId"));
        company.setName(rs.getString("name"));
        company.setPhoneNumber(rs.getString("phoneNumber"));
        company.setCity(rs.getString("city"));
        company.setCountry(rs.getString("country"));
        company.setAddress(rs.getString("address"));
        company.setEmail(rs.getString("email"));
        company.setWebsite(rs.getString("website"));
        company.setComment(rs.getString("comment"));
       company.setCreation(rs.getTimestamp("creation").toLocalDateTime());
        company.setCompanyId(rs.getLong("contactId"));


        employee.setCompanyId(company);

        Contact contact = new Contact();
        contact.setContactId(rs.getLong("contactId"));
        contact.setName(rs.getString("name"));
        contact.setSurname(rs.getString("surname"));
        contact.setPhoneNumber(rs.getString("phoneNumber"));
        contact.setCity(rs.getString("city"));
        contact.setCountry(rs.getString("country"));
        contact.setAddress(rs.getString("address"));
        contact.setEmail(rs.getString("email"));
        contact.setPost(rs.getString("postOn"));

        company.setContactId(contact);
        return employee;
    }
}
