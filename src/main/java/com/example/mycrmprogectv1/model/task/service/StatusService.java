package com.example.mycrmprogectv1.model.task.service;

import com.example.mycrmprogectv1.model.task.Status;
import com.example.mycrmprogectv1.model.task.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StatusService {
    private final JdbcTemplate jdbcTemplate;

    public void save(Status status) {
        jdbcTemplate.update("insert into status(name) values (?,?)",
                status.getName(), status);
    }


    public Status findByName(String name) {
        return jdbcTemplate.query("select * from status where name=?",
                new Object[]{name},
                new BeanPropertyRowMapper<>(Status.class))
                .stream()
                .findAny().
                orElse(null);
    }



    public Status finById(Long statusId) {
        return jdbcTemplate.query("select * from status where statusId=?",
                new Object[]{statusId},
                new BeanPropertyRowMapper<>(Status.class))
                .stream()
                .findAny()
                .orElse(null);
    }



    public List<Status> getAllStatus() {
        return jdbcTemplate.query("select * from status",
                new BeanPropertyRowMapper<>(Status.class));
    }


    public void update(Long statusId, Status status) {
        jdbcTemplate.update("update status set name=?, where statusid=?",
                status.getName(),
                status);
    }


    public void delete(Long statusId) {
        jdbcTemplate.update("delete from status where statusid=?", statusId);
    }
}
