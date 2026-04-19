package com.example.session10.model.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponseDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private LocalDate dob;

    private String address;
}