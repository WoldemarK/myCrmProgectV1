package com.example.mycrmprogectv1.model.task.mapper;

import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.company.dao.contact.Contact;
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
        task.setTaskId(rs.getLong("id"));
        task.setName(rs.getString("name"));
        task.setDescription(rs.getString("description"));
        task.setCreation(rs.getTimestamp("creation").toLocalDateTime());
        task.setStart(rs.getTimestamp("start").toLocalDateTime());
        task.setEnding(rs.getTimestamp("ending").toLocalDateTime());

        Action action = new Action();
        action.setActionId(rs.getLong("actionId"));
        action.setName(rs.getString("name"));
        task.setActionId(action);//7 task

        Status status = new Status();
        status.setStatusId(rs.getLong("statusId"));
        status.setName(rs.getString("name"));
        status.setTypeStatus(Status.TypeStatus.valueOf(rs.getString("typeStatus")));
        task.setStatusId(status);//8 task

        Contact contact = new Contact();
        contact.setContactId(rs.getLong("contactId"));
        contact.setName(rs.getString("name"));
        contact.setSurname(rs.getString("surname"));
        contact.setPhoneNumber(rs.getString("phoneNumber"));
        contact.setCity(rs.getString("city"));
        contact.setCountry(rs.getString("country"));
        contact.setAddress(rs.getString("address"));
        contact.setEmail(rs.getString("email"));
        contact.setPostOn(rs.getString("postOn"));

        contact.setPost(Contact.TypePost.valueOf(rs.getString("post")));

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
        company.setTypeCompany(Company.TypeCompany.valueOf(rs.getString("typeCompany")));

        contact.setCompanyId(company); // Company
        task.setCompanyId(company);// 9 task

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
        employee.setBirth(rs.getTimestamp("birth").toLocalDateTime());
        employee.setCompanyId(company);
        employee.setPost(Employee.TypePost.valueOf(rs.getString("post")));

        task.setEmployeeId(employee);

        return task;
    }
}
