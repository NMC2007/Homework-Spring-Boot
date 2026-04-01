package com.example.session4.Service;

import com.example.session4.Repository.StudentRepo;
import com.example.session4.model.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    public Student findById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }
    public List<Student> getAll() {
        return studentRepo.findAll();
    }
}
