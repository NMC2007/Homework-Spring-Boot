package com.example.session4.model.dto.requestDto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class InstructorCreateRequest {
    private String name;
    private String email;
}
