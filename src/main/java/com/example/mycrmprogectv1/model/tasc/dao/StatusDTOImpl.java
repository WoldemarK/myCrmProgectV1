package com.example.mycrmprogectv1.model.tasc.dao;

import com.example.mycrmprogectv1.model.tasc.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StatusDTOImpl implements StatusDTO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Status status) {
        jdbcTemplate.update("insert into status values (?,?,?)");
    }

    @Override
    public Status findByName(String name) {
        return jdbcTemplate.query("select * from status where name=?",
                new Object[]{name},
                new BeanPropertyRowMapper<>(Status.class))
                .stream()
                .findAny().
                orElse(null);
    }


    @Override
    public Status finById(Long statusId) {
        return jdbcTemplate.query("select * from action where statusId=?",
                new Object[]{statusId},
                new BeanPropertyRowMapper<>(Status.class))
                .stream()
                .findAny()
                .orElse(null);
    }


    @Override
    public List<Status> getAllStatus() {
        return jdbcTemplate.query("select * from status",
                new BeanPropertyRowMapper<>(Status.class));
    }

    @Override
    public void update(Long statusId, Status status) {
        jdbcTemplate.update("update status set name=?, typeStatus =? where statusid=?",
                status.getName(), status.getTypeStatus());
    }

    @Override
    public void delete(Long statusId) {
        jdbcTemplate.update("delete from status where statusid=?", statusId);
    }
}