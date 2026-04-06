package com.example.session4.service;

import com.example.session4.repository.CourseRepo;
import com.example.session4.repository.StudentEnrollmentRepo;
import com.example.session4.repository.StudentRepo;
import com.example.session4.model.entity.Course;
import com.example.session4.model.entity.Student;
import com.example.session4.model.entity.StudentEnrollment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentEnrollmentService {
    private final StudentEnrollmentRepo studentEnrollmentRepo;

    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;

//    public StudentEnrollment findById(Long id) {
//        return studentEnrollmentRepo.findById(id).orElse(null);
//    }
//    public List<StudentEnrollment> getAll() {
//        return  studentEnrollmentRepo.findAll();
//    }

    public String createEnrollmentStudent(Long studentId, Long courseId) {
        Student stu = studentRepo.findById( studentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên"));
        Course cou = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khoá học"));

        StudentEnrollment newStuEnrollment = new StudentEnrollment();
        newStuEnrollment.setStudent(stu);
        newStuEnrollment.setCourse(cou);

        studentEnrollmentRepo.save(newStuEnrollment);

        return "Tạo thành công khoá học";
    }
}
