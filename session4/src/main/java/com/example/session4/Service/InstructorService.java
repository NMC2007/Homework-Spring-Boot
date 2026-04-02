package com.example.session4.Service;

import com.example.session4.Repository.InstructorRepo;
import com.example.session4.model.dto.instructorDTO.InstructorCreateRequest;
import com.example.session4.model.dto.instructorDTO.InstructorOutPutDTO;
import com.example.session4.model.entity.Course;
import com.example.session4.model.entity.Instructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepo instructorRepo;

    public Instructor findById(Long id) {
        return instructorRepo.findById(id).orElse(null);
    }


    public List<Instructor> findAll() {
        return instructorRepo.findAll();
    }

    public List<InstructorOutPutDTO> getInstructors() {
        List<Instructor> instructors = findAll();
        return instructors.stream()
                .map(this::mapToDto).toList();

    }

    public List<InstructorOutPutDTO> findByName(String name) {
        List<Instructor> instructors =  instructorRepo.findByName(name);

        return instructors.stream()
                .map(this::mapToDto).toList();
    }



    public Instructor createInstructor(InstructorCreateRequest req) {
        Instructor instructor = new Instructor();

        instructor.setName(req.getName());
        instructor.setEmail(req.getEmail());

        return instructorRepo.save(instructor);
    }

    private InstructorOutPutDTO mapToDto(Instructor entity) {
        return InstructorOutPutDTO.builder()
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
