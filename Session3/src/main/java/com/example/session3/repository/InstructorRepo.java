package com.example.session3.repository;

import com.example.session3.model.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstructorRepo implements ICRUDRepo<Instructor> {
    private final List<Instructor> instructorsList = new ArrayList<>();

    public InstructorRepo() {
        instructorsList.add(new Instructor(1, "Nguyen Van A", "a@gmail.com"));
        instructorsList.add(new Instructor(2, "Tran Thi B", "b@gmail.com"));
        instructorsList.add(new Instructor(3, "Le Van C", "c@gmail.com"));
        instructorsList.add(new Instructor(4, "Pham Thi D", "d@gmail.com"));
        instructorsList.add(new Instructor(5, "Hoang Van E", "e@gmail.com"));
    }

    @Override
    public List<Instructor> findAll() {
        return instructorsList;
    }

    @Override
    public Instructor findById(int id) {
        return instructorsList.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Instructor create(Instructor data) {
        return null;
    }

    @Override
    public Instructor update(int id, Instructor data) {
        return null;
    }

    @Override
    public Instructor deleteById(int id) {
        return null;
    }
}
