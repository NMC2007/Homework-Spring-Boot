package com.example.session3.controllers;

import com.example.session3.model.Enrollment;
import com.example.session3.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Enrollment> list = enrollmentService.getAll();
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> getById(@RequestParam int id) {
        Enrollment e = enrollmentService.getById(id);
        if (e == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Enrollment enrollment) {
        Enrollment e = enrollmentService.create(enrollment);
        if (e == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Enrollment enrollment) {
        Enrollment e = enrollmentService.update(id, enrollment);
        if (e == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id) {
        Enrollment e = enrollmentService.delete(id);
        if (e == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(e, HttpStatus.NO_CONTENT);
    }
}
