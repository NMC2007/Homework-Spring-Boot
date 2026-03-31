package com.example.session3.services;

import com.example.session3.model.Course;
import com.example.session3.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICRUDService<Course> {
    private final CourseRepo courseRepo;

    @Override
    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course getById(int id) {
        return courseRepo.findById(id);
    }

    @Override
    public Course create(Course data) {
        return courseRepo.create(data);
    }

    @Override
    public Course update(int id, Course data) {
        return courseRepo.update(id, data);
    }

    @Override
    public Course delete(int id) {
        return courseRepo.deleteById(id);
    }
}
