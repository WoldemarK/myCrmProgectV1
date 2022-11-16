package com.example.mycrmprogectv1.model.task.mapper;

import com.example.mycrmprogectv1.model.сompanyсard.company.Company;
import com.example.mycrmprogectv1.model.сompanyсard.contact.Contact;
import com.example.mycrmprogectv1.model.employee.Employee;
import com.example.mycrmprogectv1.model.task.Action;
import com.example.mycrmprogectv1.model.task.Status;
import com.example.mycrmprogectv1.model.task.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {

        Task task = new Task();
        task.setId(rs.getLong("id"));
        task.setName(rs.getString("name"));
        task.setDescription(rs.getString("description"));
        task.setCreation(rs.getTimestamp("creation").toLocalDateTime());
        task.setUpdate(rs.getTimestamp("update").toLocalDateTime());
        task.setStart(rs.getTimestamp("start").toLocalDateTime());
        task.setEnding(rs.getTimestamp("ending").toLocalDateTime());

        Action action = new Action();
        action.setId(rs.getLong("Id"));
        action.setName(rs.getString("name"));
        task.setActionId(action);

        Status status = new Status();
        status.setId(rs.getLong("Id"));
        status.setName(rs.getString("name"));
        task.setStatusId(status);

        Company company = new Company();
        company.setId(rs.getLong("Id"));
        company.setName(rs.getString("name"));
        company.setPhoneNumber(rs.getString("phoneNumber"));
        company.setCity(rs.getString("city"));
        company.setCountry(rs.getString("country"));
        company.setAddress(rs.getString("address"));
        company.setEmail(rs.getString("email"));
        company.setWebsite(rs.getString("website"));
        company.setComment(rs.getString("comment"));
        company.setCreation(rs.getTimestamp("creation").toLocalDateTime());
        company.setUpdate(rs.getTimestamp("update").toLocalDateTime());
        company.setTypeCompany(rs.getString("typeCompany"));
        task.setCompanyId(company);


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
        task.setEmployeeId(employee);

        return task;
    }
}
