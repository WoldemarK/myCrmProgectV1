//package com.example.mycrmprogectv1.model.task.controller;
//
//import com.example.mycrmprogectv1.model.task.Task;
//import com.example.mycrmprogectv1.model.task.dao.TaskDAOImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.SQLException;
//import java.util.List;
//
//@RestController
//@RequestMapping("/task")
//@RequiredArgsConstructor
//public class TaskController {
//    private final TaskDAOImpl taskDAO;
//
//    @PostMapping
//    public void create(@RequestBody Task task) {
//        taskDAO.save(task);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Task>> getAllTask() {
//        return ResponseEntity.ok(taskDAO.getAllTask());
//    }
//
//    @PutMapping
//    public void update(Long id, Task task) throws SQLException {
//        this.taskDAO.update(id, task);
//    }
//
//    @DeleteMapping
//    public void delete(Long id) throws SQLException {
//        this.taskDAO.delete(id);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Task> finById(@PathVariable Long id) {
//        return ResponseEntity.ok(taskDAO.findById(id));
//    }
//
//    @GetMapping("/{name}")
//    public ResponseEntity<Task> finByName(@RequestParam String name) {
//        return ResponseEntity.ok(taskDAO.findByName(name));
//    }
//}
