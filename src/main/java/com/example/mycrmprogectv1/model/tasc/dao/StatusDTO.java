package com.example.mycrmprogectv1.model.tasc.dao;

import com.example.mycrmprogectv1.model.tasc.Action;
import com.example.mycrmprogectv1.model.tasc.Status;

import java.util.List;

public interface StatusDTO {
    void save(Status status);

    Status findByName(String name);

    Status finById(Long statusId);

    List<Status> getAllStatus();

    void update(Long statusId, Status status);

    void delete(Long statusId);
}
