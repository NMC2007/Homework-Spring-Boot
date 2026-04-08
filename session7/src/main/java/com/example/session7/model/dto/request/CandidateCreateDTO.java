package com.example.session7.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateCreateDTO {

    @NotBlank
    @Pattern(regexp = "^.{5,50}$")
    private String fullName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(value = 18)
    private int age;

    @NotNull
    @Min(value = 0)
    private int yearsOfExperience;
}
