package com.example.session4.model.dto.responseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class InstructorResponse {
    private Long instructorId;
    private String name;
    private String email;
    private List<String> courses;
}
