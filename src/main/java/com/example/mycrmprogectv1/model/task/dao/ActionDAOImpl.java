package com.example.mycrmprogectv1.model.task.dao;

import com.example.mycrmprogectv1.model.task.Action;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ActionDAOImpl implements ActionDAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Action action) {
        jdbcTemplate.update("insert into action (name )values (?)",
                action.getName(),

                action);

    }

    @Override
    public Action findByName(String typeAction) {
        return jdbcTemplate.query("select * from action where typeAction=?",
                        new Object[]{typeAction},
                        new BeanPropertyRowMapper<>(Action.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public Action finById(Long actionId) {
        return jdbcTemplate.query("select * from action where actionId=?",
                        new Object[]{actionId},
                        new BeanPropertyRowMapper<>(Action.class))
                .stream()
                .findAny()
                .orElse(null);
    }


    @Override
    public List<Action> getAllAction() {
        return jdbcTemplate.query("select * from action",
                new BeanPropertyRowMapper<>(Action.class));
    }

    @Override
    public void update(Long actionId, Action action) {
        jdbcTemplate.update("update action set name=?, where actionId=?",
                action.getName(),  actionId);
    }

    @Override
    public void delete(Long actionId) {
        jdbcTemplate.update("delete from action where actionId=?", actionId);
    }
}
