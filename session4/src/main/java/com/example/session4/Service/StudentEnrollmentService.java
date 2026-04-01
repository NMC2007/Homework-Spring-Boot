package com.example.session4.Service;

import com.example.session4.Repository.StudentEnrollmentRepo;
import com.example.session4.model.entity.StudentEnrollment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentEnrollmentService {
    private final StudentEnrollmentRepo studentEnrollmentRepo;

    public StudentEnrollment findById(Long id) {
        return studentEnrollmentRepo.findById(id).orElse(null);
    }
    public List<StudentEnrollment> getAll() {
        return  studentEnrollmentRepo.findAll();
    }
}
