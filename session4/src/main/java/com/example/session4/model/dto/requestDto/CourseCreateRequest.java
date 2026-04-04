package com.example.session4.model.dto.requestDto;

import com.example.session4.model.entity.CourseStatus;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class CourseCreateRequest {
    private String tile;
    private CourseStatus status;
    private Long instructorId;
}
