package com.example.edu.controllers;

import com.example.edu.models.Task;
import com.example.edu.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<?> findAllTask() {
        List<Task> tasksList = taskService.findAll();
        if (tasksList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(tasksList, HttpStatus.OK);
    }

    @GetMapping("/search-task")
    public ResponseEntity<?> searchTask(@RequestParam String keyword) {
        List<Task> tasksList = taskService.findByString(keyword);
        if (tasksList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(tasksList, HttpStatus.OK);
    }

    @PostMapping("/create-task")
    public ResponseEntity<?> createTask(@RequestBody Task newTask) {
        Task createTask = taskService.createData(newTask);
        if (createTask == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(createTask, HttpStatus.CREATED);
    }
}
