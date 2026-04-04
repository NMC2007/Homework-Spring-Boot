package com.example.session4.controller;

import com.example.session4.Service.CourseService;
import com.example.session4.model.dto.requestDto.CourseCreateRequest;
import com.example.session4.model.dto.responseDto.CourseResponse;
import com.example.session4.model.entity.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAllCourse() {
        List<CourseResponse> listCourse = courseService.getAll();
        if (listCourse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(listCourse,HttpStatus.OK);
    }

    @PostMapping("/create-course")
    public ResponseEntity<?> createCourse(@RequestBody CourseCreateRequest req) {
        String status = courseService.createCourse(req);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/update-course")
    public ResponseEntity<?> updateCourse(@RequestParam Long id, @RequestBody CourseCreateRequest req) {
        String status = courseService.updateCourse(id, req);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
