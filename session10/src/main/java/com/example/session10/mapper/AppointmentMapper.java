package com.example.session10.mapper;

import com.example.session10.model.dto.response.AppointmentResponseDTO;
import com.example.session10.model.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "doctor.name", target = "doctorName")
    AppointmentResponseDTO toDto(Appointment appointment);
}
