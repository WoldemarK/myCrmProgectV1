package com.example.mycrmprogectv1.model.task.repository;

import com.example.mycrmprogectv1.model.task.Task;
import com.example.mycrmprogectv1.model.task.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskServiceRepositoryImpl implements TaskRepository {
    private final JdbcTemplate jdbcTemplate;
    private static String INSET = "insert into task (name,description,creation,start,ending,actionId,statusId,companyId,employeeId)" +
            " values (?,?,?,?,?,?,?,?,?)";
    private static String SELECT_BY_ID = "select * from task where taskId=?";
    private static String SELECT_BY_NAME = "select * from task where name=?";
    private static String DELETE = "delete from task where taskid=?";
    private static String GET_ALL = "select * from task join action a on task.actionid = a.actionid " +
            "join status s on task.statusid = s.statusid  " +
            "join company c on task.companyid = c.companyid  " +
            "join employee e on task.employeeid = e.employeeid";

    public void save(Task task) {
        jdbcTemplate.update(INSET,
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


    public Task findById(Long taskId) {
        return jdbcTemplate.query(SELECT_BY_ID, new Object[]{taskId}, new TaskMapper())
                .stream()
                .findAny()
                .orElse(null);
    }


    public Task findByName(String name) {
        return jdbcTemplate.query(SELECT_BY_NAME, new Object[]{name}, new TaskMapper())
                .stream()
                .findAny()
                .orElse(null);
    }


    public void delete(Long taskId) {
        jdbcTemplate.update(DELETE, taskId);
    }


    public List<Task> getAllTask() {
        return jdbcTemplate.query(GET_ALL, new TaskMapper());


    }
}