package com.example.session4.model.dto.courseDTO;

import com.example.session4.model.entity.CourseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseCreateRequest {
    private String tile;
    private CourseStatus status;
    private Long instructorId;
}
