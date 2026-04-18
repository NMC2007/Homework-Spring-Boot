package com.example.session10.service;

import com.example.session10.advice.DepartmentNotFoundException;
import com.example.session10.advice.DuplicateResourceException;
import com.example.session10.model.dto.request.DoctorCreateDTO;
import com.example.session10.model.dto.response.DoctorResponseDTO;
import com.example.session10.model.entity.Doctor;
import com.example.session10.repository.DoctorRepository;
import com.example.session10.mapper.DoctorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    // 1. Lấy danh sách toàn bộ bác sĩ
    public List<DoctorResponseDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toDto)
                .toList();
    }

    // 2. Lấy chi tiết theo ID
    public DoctorResponseDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));

        return doctorMapper.toDto(doctor);
    }

    // 3. Thêm mới bác sĩ
    public Doctor createDoctor(DoctorCreateDTO req) {
        Doctor doctor = doctorMapper.toEntity(req);
        if (doctorRepository.existsByEmail(req.getEmail())) {
            throw new DuplicateResourceException("Email đã tồn tại");
        }

        if (doctorRepository.existsByPhone(req.getPhone())) {
            throw new DuplicateResourceException("Số điện thoại đã tồn tại");
        }

        return doctorRepository.save(doctor);
    }

    // 4. Cập nhật bác sĩ
    public Doctor updateDoctor(Long id, DoctorCreateDTO req) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));

        if (doctorRepository.existsByEmail(req.getEmail())) {
            throw new DuplicateResourceException("Email đã tồn tại");
        }

        if (doctorRepository.existsByPhone(req.getPhone())) {
            throw new DuplicateResourceException("Số điện thoại đã tồn tại");
        }

        // map dữ liệu từ DTO vào entity cũ
        doctorMapper.updateFromDto(req, doctor);

        return doctorRepository.save(doctor);
    }

    // 5. Xóa bác sĩ
    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));

        doctorRepository.delete(doctor);
    }
}
