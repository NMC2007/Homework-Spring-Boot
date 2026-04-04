package com.example.session4.Service;

import com.example.session4.Repository.CourseRepo;
import com.example.session4.Repository.InstructorRepo;
import com.example.session4.model.dto.requestDto.CourseCreateRequest;
import com.example.session4.model.dto.responseDto.CourseResponse;
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
    private final InstructorService instructorService;

    public List<CourseResponse> getAll() {
        List<Course> listCourse = courseRepo.findAll();

        return listCourse.stream().map(this::mapToDto).toList();
    }

    private CourseResponse mapToDto(Course entity) {
        return CourseResponse.builder()
                .id(entity.getId())
                .tile(entity.getTile())
                .status(entity.getStatus())
                .instructor(instructorService.mapToDto(entity.getInstructor()))
                .build();
    }

    public Course findById(Long id) {
        return courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dữ liệu"));
    }

    public String createCourse(CourseCreateRequest req) {
        Instructor instructor = instructorRepo.findById(req.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thông tin giáo viên"));

        Course newCourse = new Course();
        newCourse.setTile(req.getTile());
        newCourse.setStatus(req.getStatus());
        newCourse.setInstructor(instructor);

        courseRepo.save(newCourse);

        return "Tạo mới khoá học thành công";
    }

    public String updateCourse(Long id, CourseCreateRequest putReq) {
        Course newCourse = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Khoá học không tồn tại"));

        Instructor instructor = instructorRepo.findById(putReq.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thông tin giáo viên"));

        newCourse.setTile(putReq.getTile());
        newCourse.setStatus(putReq.getStatus());
        newCourse.setInstructor(instructor);

        courseRepo.save(newCourse);

        return "Update khoá học thành công";
    }
}
