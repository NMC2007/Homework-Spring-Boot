package com.example.session4.repository;

import com.example.session4.model.entity.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrollmentRepo extends JpaRepository<StudentEnrollment, Long> {
}
