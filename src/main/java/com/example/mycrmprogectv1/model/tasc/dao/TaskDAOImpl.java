package com.example.mycrmprogectv1.model.tasc.dao;

import com.example.mycrmprogectv1.model.tasc.Action;
import com.example.mycrmprogectv1.model.tasc.Status;
import com.example.mycrmprogectv1.model.tasc.Task;

import java.util.List;

public class TaskDAOImpl implements TaskDAO{


    @Override
    public void save(Task task) {

    }

    @Override
    public Task findById(Long id) {
        return null;
    }

    @Override
    public Task findByName(String name) {
        return null;
    }

    @Override
    public void update(Long id, Task task) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Task> getAllTask() {
        return null;
    }

    @Override
    public Task getTaskAction(Action action) {
        return null;
    }

    @Override
    public Task getTaskActionType(Action.TypeAction action) {
        return null;
    }

    @Override
    public Task getTaskStatus(Status status) {
        return null;
    }

    @Override
    public Task getTaskStatusType(Status.TypeStatus status) {
        return null;
    }
}
