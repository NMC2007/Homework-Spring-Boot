package com.example.session3.repository;

import com.example.session3.model.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollmentRepo implements ICRUDRepo<Enrollment> {
    private final List<Enrollment> enrollmentsList = new ArrayList<>();

    public EnrollmentRepo() {
        enrollmentsList.add(new Enrollment(1, 1, "Nguyen Van Student1"));
        enrollmentsList.add(new Enrollment(2, 1, "Tran Thi Student2"));
        enrollmentsList.add(new Enrollment(3, 2, "Le Van Student3"));
        enrollmentsList.add(new Enrollment(4, 3, "Pham Thi Student4"));
        enrollmentsList.add(new Enrollment(5, 5, "Hoang Van Student5"));
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentsList;
    }

    @Override
    public Enrollment findById(int id) {
        return enrollmentsList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Enrollment create(Enrollment data) {
        enrollmentsList.add(data);
        return data;
    }

    @Override
    public Enrollment update(int id, Enrollment data) {
        Enrollment e = findById(id);
        if (e != null) {
            enrollmentsList.set(enrollmentsList.indexOf(e), data);
            return data;
        }
        return null;
    }

    @Override
    public Enrollment deleteById(int id) {
        Enrollment e = findById(id);
        if (e != null) {
            enrollmentsList.remove(e);
            return e;
        }
        return null;
    }
}
