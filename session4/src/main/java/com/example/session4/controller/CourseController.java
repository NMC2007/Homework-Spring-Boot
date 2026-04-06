package com.example.session4.controller;

import com.example.session4.service.CourseService;
import com.example.session4.model.dto.requestDto.CourseCreateRequest;
import com.example.session4.model.dto.responseDto.CourseResponse;
import com.example.session4.model.dto.responseDto.CourseResponseV2;
import com.example.session4.model.dto.responseDto.PageResponse;
import com.example.session4.model.entity.CourseStatus;
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

    @GetMapping("/v2")
    public ResponseEntity<?> getAllCourseV2() {
        List<CourseResponseV2> listCourse = courseService.getAllV2();
        if (listCourse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(listCourse,HttpStatus.OK);
    }

    @GetMapping("/page-able")
    public ResponseEntity<?> getCourseByPaginate (
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String field,
            @RequestParam(defaultValue = "ASC") String order,
            @RequestParam(defaultValue = "ACTIVE")CourseStatus status

            ) {
        PageResponse<CourseResponse> pageCourse = courseService.getCourseByPage(pageNumber, pageSize, field, order, status);
        return new ResponseEntity<>(pageCourse, HttpStatus.OK);
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
