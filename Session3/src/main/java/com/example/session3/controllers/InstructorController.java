package com.example.session3.controllers;

import com.example.session3.model.Instructor;
import com.example.session3.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Instructor> list = instructorService.getAll();
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> getById(@RequestParam int id) {
        Instructor i = instructorService.getById(id);
        if (i == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Instructor instructor) {
        Instructor i = instructorService.create(instructor);
        if (i == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Instructor instructor) {
        Instructor i = instructorService.update(id, instructor);
        if (i == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id) {
        Instructor i = instructorService.delete(id);
        if (i == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(i, HttpStatus.NO_CONTENT);
    }
}
