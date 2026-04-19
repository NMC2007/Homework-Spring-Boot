package com.example.session10.repository;

import com.example.session10.model.dto.response.AppointmentResponseDTO;
import com.example.session10.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("""
        SELECT new com.example.session10.model.dto.response.AppointmentResponseDTO(
            a.id,
            a.appointmentTime,
            a.note,
            a.status,
            d.id,
            d.name
        )
        FROM Appointment a
        JOIN a.doctor d
        WHERE d.id = :doctorId
    """)
    List<AppointmentResponseDTO> findAllByDoctorId(Long doctorId);
}