package com.example.session10.controller;

import com.example.session10.model.dto.request.DoctorCreateDTO;
import com.example.session10.model.dto.response.DoctorResponseDTO;
import com.example.session10.model.entity.Doctor;
import com.example.session10.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    // 1. Lấy danh sách tất cả bác sĩ
    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    // 2. Lấy chi tiết bác sĩ theo ID
    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    // 3. Thêm mới bác sĩ
    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody DoctorCreateDTO dto) {
        return ResponseEntity.ok(doctorService.createDoctor(dto));
    }

    // 4. Cập nhật bác sĩ
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable Long id,
            @Valid @RequestBody DoctorCreateDTO dto
    ) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, dto));
    }

    // 5. Xóa bác sĩ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}