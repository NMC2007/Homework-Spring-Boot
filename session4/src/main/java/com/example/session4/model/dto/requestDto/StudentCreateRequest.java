package com.example.session4.model.dto.requestDto;

import com.example.session4.model.entity.CourseStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class StudentCreateRequest {
    private String name;
    private String email;
}
