package com.example.session10.service;

import com.example.session10.advice.DepartmentNotFoundException;
import com.example.session10.mapper.PatientMapper;
import com.example.session10.model.dto.response.PatientResponseDTO;
import com.example.session10.model.entity.Patient;
import com.example.session10.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientResponseDTO findPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Không tìm thấy bệnh nhân với id: " + id));
        return patientMapper.toDto(patient);
    }
}
