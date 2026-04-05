package com.example.session4.model.dto.responseDto;

import com.example.session4.model.entity.CourseStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CourseResponseV2 {
    private Long id;
    private String tile;
    private CourseStatus status;
}

