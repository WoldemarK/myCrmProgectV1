package com.example.mycrmprogectv1.model.task.repository;


import com.example.mycrmprogectv1.model.task.Action;

import java.util.List;

public interface ActionRepository {
    void save(Action action);

    Action findByName(String nameAction);

    Action finById(Long id);

    List<Action> getAllAction();

    void update(Long id, Action action);

    void delete(Long id);

}
