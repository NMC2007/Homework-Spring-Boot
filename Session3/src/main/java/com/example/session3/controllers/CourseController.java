package com.example.session3.controllers;

import com.example.session3.model.Course;
import com.example.session3.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        List<Course> courses = courseService.getAll();
        if (courses.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/find-course-by-id")
    public ResponseEntity<?> getCourseById(@RequestParam int id) {
        Course c = courseService.getById(id);
        if (c == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping("/create-course")
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        Course c = courseService.create(course);
        if (c == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @PutMapping("/update-info-creatre/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) {
        Course c = courseService.update(id, course);
        if (c == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @DeleteMapping("/delete-course")
    public ResponseEntity<?> deleteCourse(@RequestParam int id) {
        Course c = courseService.delete(id);
        if (c == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(c, HttpStatus.NO_CONTENT);
    }
}
