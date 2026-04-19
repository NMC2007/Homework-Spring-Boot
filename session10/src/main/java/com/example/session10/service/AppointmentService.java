package com.example.session10.service;

import com.example.session10.advice.DepartmentNotFoundException;
import com.example.session10.model.dto.response.AppointmentResponseDTO;
import com.example.session10.repository.AppointmentRepository;
import com.example.session10.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    private final DoctorRepository doctorRepository;

    public List<AppointmentResponseDTO> getAllAppointmentByDoctorId(Long doctorId) {

        // 1. Check tồn tại doctor
        if (!doctorRepository.existsById(doctorId)) {
            throw new DepartmentNotFoundException("Không tìm thấy bác sĩ với id: " + doctorId);
        }

        // 2. Lấy danh sách lịch hẹn
        return appointmentRepository.findAllByDoctorId(doctorId);
    }
}
