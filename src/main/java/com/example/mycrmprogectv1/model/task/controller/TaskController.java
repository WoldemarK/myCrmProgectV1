package com.example.mycrmprogectv1.model.task.controller;

import com.example.mycrmprogectv1.model.task.Task;
import com.example.mycrmprogectv1.model.task.repository.TaskServiceRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskServiceRepositoryImpl service;

    @PostMapping
    public void create(@RequestBody Task task) {
        service.save(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask() {
        return ResponseEntity.ok(service.getAllTask());
    }

    @DeleteMapping
    public void delete(Long id) throws SQLException {
        this.service.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> finById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Task> finByName(@RequestParam String name) {
        return ResponseEntity.ok(service.findByName(name));
    }
}
