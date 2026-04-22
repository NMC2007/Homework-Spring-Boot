package com.example.session10.controller;

import com.example.session10.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prescription")
@RequiredArgsConstructor
public class PrescriptionCreateController {
    private PrescriptionService prescriptionService;
//    @GetMapping
//    public ResponseEntity<?> findPrescriptionByPatientId(@RequestParam Long patientId, @RequestParam Long prescriptionId) {
//        PrescriptionResponseDTO res = prescriptionService.getPrescriptionByPatientId(patientId, prescriptionId);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }

    @GetMapping("/patients/{patientId}/prescriptions/{prescriptionId}")
    public  ResponseEntity<?> findPrescriptionByPatientId(
            @PathVariable Long patientId,
            @PathVariable Long prescriptionId
    ) {
        return new ResponseEntity<>(prescriptionService.getPrescriptionByPatientId(patientId, prescriptionId), HttpStatus.OK);
    }
}
