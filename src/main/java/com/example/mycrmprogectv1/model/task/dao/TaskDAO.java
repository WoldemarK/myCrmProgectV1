package com.example.mycrmprogectv1.model.task.dao;

import com.example.mycrmprogectv1.model.task.Task;

import java.util.List;

public interface TaskDAO {

    void save(Task task);

    Task findById(Long id);

    Task findByName(String name);

    void update(Long id, Task task);

    void delete(Long id);

    List<Task> getAllTask();

}
