package com.example.session4.Service;

import com.example.session4.Repository.InstructorRepo;
import com.example.session4.model.dto.InstructorCreateRequest;
import com.example.session4.model.entity.Instructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepo instructorRepo;

    public Instructor findById(Long id) {
        return instructorRepo.findById(id).orElse(null);
    }


    public List<Instructor> findAll() {
        return instructorRepo.findAll();
    }

    public Instructor createInstructor(InstructorCreateRequest req) {
        Instructor instructor = new Instructor();

        instructor.setName(req.getName());
        instructor.setEmail(req.getEmail());

        return instructorRepo.save(instructor);
    }
}
