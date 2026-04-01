package com.example.session4.Service;

import com.example.session4.Repository.CourseRepo;
import com.example.session4.model.entity.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepo courseRepo;

    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    public Course findById(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

}
