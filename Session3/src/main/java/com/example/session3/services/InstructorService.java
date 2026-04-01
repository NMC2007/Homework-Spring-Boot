package com.example.session3.services;

import com.example.session3.model.Instructor;
import com.example.session3.repository.InstructorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements ICRUDService<Instructor> {
    private final InstructorRepo instructorRepo;

    @Override
    public List<Instructor> getAll() {
        return instructorRepo.findAll();
    }

    @Override
    public Instructor getById(int id) {
        return instructorRepo.findById(id);
    }

    @Override
    public Instructor create(Instructor data) {
        return instructorRepo.create(data);
    }

    @Override
    public Instructor update(int id, Instructor data) {
        return instructorRepo.update(id, data);
    }

    @Override
    public Instructor delete(int id) {
        return instructorRepo.deleteById(id);
    }
}
