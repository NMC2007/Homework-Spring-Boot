package com.example.session4.repository;

import com.example.session4.model.entity.Course;
import com.example.session4.model.entity.CourseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    @Query("SELECT c FROM Course c WHERE c.status = :status")
    Page<Course> findAllByStatus (@Param("status") CourseStatus status, Pageable pageable);
}
