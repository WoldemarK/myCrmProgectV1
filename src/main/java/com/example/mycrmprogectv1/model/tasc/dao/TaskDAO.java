package com.example.mycrmprogectv1.model.tasc.dao;

import com.example.mycrmprogectv1.model.tasc.Action;
import com.example.mycrmprogectv1.model.tasc.Status;
import com.example.mycrmprogectv1.model.tasc.Task;

import java.util.List;

public interface TaskDAO {

    void save(Task task);

    Task findById(Long id);

    Task findByName(String name);

    void update(Long id, Task task);

    void delete(Long id);

    List<Task> getAllTask();

    Task getTaskAction(Action action);
    Task getTaskActionType(Action.TypeAction action);

    Task getTaskStatus(Status status);
    Task getTaskStatusType(Status.TypeStatus status);
}
