package com.example.mycrmprogectv1.model.task.controller;

import com.example.mycrmprogectv1.model.task.Action;
import com.example.mycrmprogectv1.model.task.dao.ActionDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/act")
@RequiredArgsConstructor
public class ActionController {
    public final ActionDAOImpl actionDAO;

    @GetMapping
    public ResponseEntity<List<Action>> getAll() {
        return ResponseEntity.ok(actionDAO.getAllAction());
    }
}
