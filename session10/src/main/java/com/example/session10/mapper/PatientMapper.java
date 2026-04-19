package com.example.session10.mapper;

import com.example.session10.model.dto.response.PatientResponseDTO;
import com.example.session10.model.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PrescriptionMapper.class})
public interface PatientMapper {

    // Map Entity -> DTO
    PatientResponseDTO toDto(Patient patient);
}