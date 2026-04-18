package com.example.session10.mapper;

import com.example.session10.model.dto.request.DoctorCreateDTO;
import com.example.session10.model.dto.response.DoctorResponseDTO;
import com.example.session10.model.entity.Doctor;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(source = "dob", target = "dob")
    Doctor toEntity(DoctorCreateDTO dto);

    DoctorResponseDTO toDto(Doctor doctor);

    void updateFromDto(DoctorCreateDTO dto, @MappingTarget Doctor doctor);
}
