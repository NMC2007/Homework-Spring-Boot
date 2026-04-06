package com.example.session4.controller;

import com.example.session4.service.StudentEnrollmentService;
import com.example.session4.service.StudentService;
import com.example.session4.model.dto.requestDto.EnrollmentCreateRequest;
import com.example.session4.model.dto.requestDto.StudentCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentEnrollmentService studentEnrollmentService;

    @PostMapping("/create-student")
    public ResponseEntity<?> createStudent(@RequestBody StudentCreateRequest req) {
        String status =  studentService.createStudent(req);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/enrollment")
    public ResponseEntity<?> addStudentToEnrollment(@RequestBody EnrollmentCreateRequest req) {
        String status = studentEnrollmentService.createEnrollmentStudent(req.getStudentId(), req.getCourseId());
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
