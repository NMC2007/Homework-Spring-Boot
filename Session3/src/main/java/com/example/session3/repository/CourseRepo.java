package com.example.session3.repository;

import com.example.session3.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo implements ICRUDRepo<Course> {
    private final List<Course> coursesList = new ArrayList<>();

    public CourseRepo() {
        coursesList.add(new Course(1, 1, "Java Core", "ACTIVE"));
        coursesList.add(new Course(2, 2, "Spring Boot", "ACTIVE"));
        coursesList.add(new Course(3, 3, "Data Structures", "INACTIVE"));
        coursesList.add(new Course(4, 4, "Database", "ACTIVE"));
        coursesList.add(new Course(5, 5, "Web Development", "ACTIVE"));
    }

    @Override
    public List<Course> findAll() {
        return coursesList;
    }

    @Override
    public Course findById(int id) {
        return coursesList.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Course create(Course data) {
        coursesList.add(data);
        return data;
    }

    @Override
    public Course update(int id, Course data) {
        Course c = findById(id);
        if (c != null) {
            coursesList.set(coursesList.indexOf(c), data);
            return data;
        }
        return null;
    }

    @Override
    public Course deleteById(int id) {
        Course c = findById(id);
        if (c != null) {
            coursesList.remove(c);
            return c;
        }
        return null;
    }
}
