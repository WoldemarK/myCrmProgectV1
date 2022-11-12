package com.example.mycrmprogectv1.model.task.dao;

import com.example.mycrmprogectv1.model.task.Task;
import com.example.mycrmprogectv1.model.task.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskDAOImpl implements TaskDAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Task task) {
        jdbcTemplate.update("insert into task (name,description,creation," +
                        "start,ending,actionId,statusId,companyId,employeeId) values (?,?,?,?,?,?,?,?,?)",
                task.getName(),
                task.getDescription(),
                task.getCreation(),
                task.getStart(),
                task.getEnding(),
                task.getActionId(),
                task.getActionId(),
                task.getStatusId(),
                task.getEmployeeId(),
                task);
    }

    @Override
    public Task findById(Long taskId) {
        return jdbcTemplate.query("select * from task where taskId=?",
                        new Object[]{taskId},
                        new TaskMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public Task findByName(String name) {
        return jdbcTemplate.query("select * from task where name=?",
                        new Object[]{name},
                        new TaskMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(Long taskId, Task task) {
        jdbcTemplate.update("update task set " +
                        "name=?," +
                        "description=?," +
                        "start=?," +
                        "ending=?," +
                        "actionId=?," +
                        "statusId=?," +
                        "companyId=?," +
                        "employeeId=?" +
                        "where taskId =?",
                task.getName(), task.getDescription(),
                task.getStart(), task.getEnding(),
                task.getActionId(), task.getStatusId(),
                task.getCompanyId(), task.getEmployeeId(), taskId);
    }

    @Override
    public void delete(Long taskId) {
        jdbcTemplate.update("delete from task where taskid=?", taskId);
    }

    @Override
    public List<Task> getAllTask() {
        return jdbcTemplate.query("select * from task " +
                "join action a on task.actionid = a.actionid " +
                "join status s on task.statusid = s.statusid " +
                "join company c on task.companyid = c.companyid " +
                "join employee e on task.employeeid = e.employeeid", new TaskMapper());


    }
}