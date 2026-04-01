package com.example.session3.services;

import com.example.session3.model.Enrollment;
import com.example.session3.repository.EnrollmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService implements ICRUDService<Enrollment> {
    private final EnrollmentRepo enrollmentRepo;

    @Override
    public List<Enrollment> getAll() {
        return enrollmentRepo.findAll();
    }

    @Override
    public Enrollment getById(int id) {
        return enrollmentRepo.findById(id);
    }

    @Override
    public Enrollment create(Enrollment data) {
        return enrollmentRepo.create(data);
    }

    @Override
    public Enrollment update(int id, Enrollment data) {
        return enrollmentRepo.update(id, data);
    }

    @Override
    public Enrollment delete(int id) {
        return enrollmentRepo.deleteById(id);
    }
}
