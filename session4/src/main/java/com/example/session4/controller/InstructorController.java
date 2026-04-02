package com.example.session4.controller;

import com.example.session4.Service.InstructorService;
import com.example.session4.model.dto.instructorDTO.InstructorCreateRequest;
import com.example.session4.model.dto.instructorDTO.InstructorOutPutDTO;
import com.example.session4.model.entity.Instructor;
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

    @GetMapping("/test")
    public List<InstructorOutPutDTO> getInstructor() {
        return instructorService.getInstructors();
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByName(@RequestParam String name) {
        List<InstructorOutPutDTO> i = instructorService.findByName(name);

        if (i.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createInstructor(@RequestBody InstructorCreateRequest data) {
        Instructor i = instructorService.createInstructor(data);
        if (i == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(i, HttpStatus.OK);
    }
}
