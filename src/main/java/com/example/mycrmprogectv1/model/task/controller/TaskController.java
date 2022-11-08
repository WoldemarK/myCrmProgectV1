package com.example.mycrmprogectv1.model.task.controller;

import com.example.mycrmprogectv1.model.task.Task;
import com.example.mycrmprogectv1.model.task.dao.TaskDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskDAOImpl taskDAO;
    @GetMapping
    public ResponseEntity<List<Task>>getAllTask(){
        return ResponseEntity.ok(taskDAO.getAllTask());
    }
}
