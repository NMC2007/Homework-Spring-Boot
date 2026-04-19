package com.example.session10.mapper;

import com.example.session10.model.dto.response.PrescriptionResponseDTO;
import com.example.session10.model.entity.Prescription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {

//    @Mapping(source = "patient.id", target = "patientId")
//    @Mapping(source = "patient.name", target = "patientName")
    PrescriptionResponseDTO toDto(Prescription prescription);
}
