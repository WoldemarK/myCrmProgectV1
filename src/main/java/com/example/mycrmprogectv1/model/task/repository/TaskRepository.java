package com.example.mycrmprogectv1.model.task.repository;

import com.example.mycrmprogectv1.model.task.Task;

import java.util.List;

public interface TaskRepository {

    void save(Task task);

    Task findById(Long id);

    Task findByName(String name);

    void update(Long id, Task task);

    void delete(Long id);

    List<Task> getAllTask();

}
