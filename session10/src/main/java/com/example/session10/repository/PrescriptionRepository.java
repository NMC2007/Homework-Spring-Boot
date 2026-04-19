package com.example.session10.repository;

import com.example.session10.model.dto.response.PrescriptionResponseDTO;
import com.example.session10.model.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    @Query("""
    SELECT new com.example.session10.model.dto.response.PrescriptionResponseDTO(
        p.id,
        p.prescriptionDate,
        p.description,
        pt.id,
        pt.name
    )
    FROM Prescription p
    JOIN p.patient pt
    WHERE p.id = :prescriptionId AND pt.id = :patientId
""")
    PrescriptionResponseDTO findByIdAndPatientId(Long prescriptionId, Long patientId);
}
