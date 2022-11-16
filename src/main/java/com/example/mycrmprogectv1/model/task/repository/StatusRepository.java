package com.example.mycrmprogectv1.model.task.repository;

import com.example.mycrmprogectv1.model.task.Status;

import java.util.List;

public interface StatusRepository {
    void save(Status status);

    Status findByName(String name);

    Status finById(Long statusId);

    List<Status> getAllStatus();

    void update(Long statusId, Status status);

    void delete(Long statusId);
}
