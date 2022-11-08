package com.example.mycrmprogectv1.model.task.dao;


import com.example.mycrmprogectv1.model.task.Action;

import java.util.List;

public interface ActionDAO {
    void save(Action action);

    Action findByName(String nameAction);

    Action finById(Long id);

    List<Action> getAllAction();

    void update(Long id, Action action);

    void delete(Long id);

}
