package com.example.session4.controller;

import com.example.session4.Service.InstructorService;
import com.example.session4.model.dto.requestDto.InstructorCreateRequest;
import com.example.session4.model.dto.responseDto.InstructorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping
    public ResponseEntity<?> getAllInstructor() {
        List<InstructorResponse> insList = instructorService.getAll();
        if (insList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(insList, HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> findInstructorById(@RequestParam Long id) {
        try {
            InstructorResponse ins = instructorService.findInstructorById(id);
            return new ResponseEntity<>(ins, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create-instructor")
    public ResponseEntity<?> createInstructor(@RequestBody InstructorCreateRequest req) {
        InstructorResponse ins = instructorService.createInstructor(req);
        return new ResponseEntity<>(ins, HttpStatus.OK);
    }
}
