package com.example.session4.service;

import com.example.session4.repository.CourseRepo;
import com.example.session4.repository.InstructorRepo;
import com.example.session4.model.dto.requestDto.CourseCreateRequest;
import com.example.session4.model.dto.responseDto.CourseResponse;
import com.example.session4.model.dto.responseDto.CourseResponseV2;
import com.example.session4.model.dto.responseDto.PageResponse;
import com.example.session4.model.entity.Course;
import com.example.session4.model.entity.CourseStatus;
import com.example.session4.model.entity.Instructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<CourseResponseV2> getAllV2() {
        List<Course> listCourse = courseRepo.findAll();

        return listCourse.stream().map(this::mapToDtoV2).toList();
    }

    private CourseResponse mapToDto(Course entity) {
        return CourseResponse.builder()
                .id(entity.getId())
                .tile(entity.getTile())
                .status(entity.getStatus())
                .instructor(instructorService.mapToDto(entity.getInstructor()))
                .build();
    }

    private CourseResponseV2 mapToDtoV2(Course entity) {
        return CourseResponseV2.builder()
                .id(entity.getId())
                .status(entity.getStatus())
                .tile(entity.getTile())
                .build();
    }

    public PageResponse<CourseResponse> getCourseByPage(int pageNumber, int pageSize, String field, String order, CourseStatus status) {
        Sort sort = order.equalsIgnoreCase("asc")
                ? Sort.by(field).ascending()
                : Sort.by(field).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Course> coursePage = getCourses(status, pageable);
        Page<CourseResponse> page = coursePage.map(this::mapToDto);

        return PageResponse.<CourseResponse>builder()
                .items(page.getContent())
                .page(page.getNumber())
                .size(page.getSize())
                .totalItems(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .isLast(page.isLast())
                .build();
    }

    private Page<Course> getCourses(CourseStatus status, Pageable pageable) {
        Page<Course> coursePage = courseRepo.findAllByStatus(status, pageable);
        return coursePage;
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
