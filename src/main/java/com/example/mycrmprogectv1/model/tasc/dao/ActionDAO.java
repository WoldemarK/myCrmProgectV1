package com.example.mycrmprogectv1.model.tasc.dao;


import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.tasc.Action;

import java.util.List;

public interface ActionDAO {
    void save(Action action);

    Action findByName(String nameAction);

    Action finById(Long id);

    Action findByActionTyp(Action.TypeAction typeAction);

    List<Action> getAllAction();

    void update(Long id, Action action);

    void delete(Long id);
}
