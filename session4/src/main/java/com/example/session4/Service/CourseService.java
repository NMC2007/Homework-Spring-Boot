package com.example.session4.Service;

import com.example.session4.Repository.CourseRepo;
import com.example.session4.Repository.InstructorRepo;
import com.example.session4.model.dto.courseDTO.CourseCreateRequest;
import com.example.session4.model.entity.Course;
import com.example.session4.model.entity.Instructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepo courseRepo;

    private final InstructorRepo instructorRepo;

    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    public Course findById(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

//    public Course createCourse(CourseCreateRequest req) {
//        Instructor instructor = instructorRepo.findById(req.getInstructorId())
//                .orElseThrow(() -> new RuntimeException("Instructor not found"));
//
//        Course newCourse = new Course();
//        newCourse.setTile(req.getTile());
//        newCourse.setStatus(req.getStatus());
//    }

}
