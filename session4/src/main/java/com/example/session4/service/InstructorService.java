package com.example.session4.service;

import com.example.session4.repository.InstructorRepo;
import com.example.session4.model.dto.requestDto.InstructorCreateRequest;
import com.example.session4.model.dto.responseDto.InstructorResponse;
import com.example.session4.model.entity.Course;
import com.example.session4.model.entity.Instructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepo instructorRepo;

    public InstructorResponse findInstructorById(Long id) {
        Instructor ins = instructorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dữ liệu"));
        return mapToDto(ins);
    }

    public InstructorResponse createInstructor(InstructorCreateRequest req) {
        Instructor newIns = new Instructor();

        newIns.setName(req.getName());
        newIns.setEmail(req.getEmail());

        instructorRepo.save(newIns);
        return mapToDto(newIns);
    }

    public List<InstructorResponse> getAll() {
        List<Instructor> listIns = instructorRepo.findAll();

        return listIns.stream().map(this::mapToDto).toList();
    }

    public InstructorResponse mapToDto(Instructor entity) {
        return InstructorResponse.builder()
                .instructorId(entity.getInstructorId())
                .name(entity.getName())
                .email(entity.getEmail())
                .courses(
                        entity.getCourses() == null
                                ? List.of()
                                : entity.getCourses()
                                .stream()
                                .map(Course::getTile)
                                .toList()
                )
                .build();
    }
}
