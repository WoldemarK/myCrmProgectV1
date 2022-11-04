package com.example.mycrmprogectv1.model.tasc.dao;

import com.example.mycrmprogectv1.model.tasc.Task;
import org.springframework.stereotype.Component;

import java.util.List;

public interface TaskDAO {

    void save(Task task);

    Task findById(Long id);

    Task findByName(String name);

    void update(Long id, Task task);

    void delete(Long id);

    List<Task> getAllTask();

}
