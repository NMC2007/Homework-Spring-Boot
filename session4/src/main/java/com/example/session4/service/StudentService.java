package com.example.session4.service;

import com.example.session4.repository.StudentRepo;
import com.example.session4.model.dto.requestDto.StudentCreateRequest;
import com.example.session4.model.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

//    public Student findById(Long id) {
//        return studentRepo.findById(id).orElse(null);
//    }
//    public List<Student> getAll() {
//        return studentRepo.findAll();
//    }

    public String createStudent(StudentCreateRequest req) {
        Student newStu = new Student();

        newStu.setName(req.getName());
        newStu.setEmail(req.getEmail());

        studentRepo.save(newStu);

        return "Thêm mới học sinh thành công";
    }
}
