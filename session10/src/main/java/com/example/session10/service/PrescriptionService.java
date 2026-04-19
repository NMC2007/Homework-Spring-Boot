package com.example.session10.service;

import com.example.session10.advice.DepartmentNotFoundException;
import com.example.session10.mapper.PrescriptionMapper;
import com.example.session10.model.dto.response.PrescriptionResponseDTO;
import com.example.session10.model.entity.Patient;
import com.example.session10.model.entity.Prescription;
import com.example.session10.repository.PatientRepository;
import com.example.session10.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final PatientRepository patientRepository;

    public PrescriptionResponseDTO getPrescriptionByPatientId(Long patientId, Long prescriptionId){

        // 1. Check patient tồn tại
        if (!patientRepository.existsById(patientId)) {
            throw new DepartmentNotFoundException("Không tìm thấy bệnh nhân với id: " + patientId);
        }

        // 2. Lấy đơn thuốc (đã trả thẳng DTO)
        PrescriptionResponseDTO dto =
                prescriptionRepository.findByIdAndPatientId(prescriptionId, patientId);

        // 3. Check nếu không có
        if (dto == null) {
            throw new DepartmentNotFoundException("Đơn thuốc không tồn tại hoặc không thuộc bệnh nhân này");
        }

        return dto;
    }
}
