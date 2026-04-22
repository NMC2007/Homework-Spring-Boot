package com.example.session9.controller;

import com.example.session9.mapping.MapToAPIResponse;
import com.example.session9.model.dto.request.EmployeeCreateDTO;
import com.example.session9.model.entity.Employee;
import com.example.session9.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeCreateDTO req) {
        Employee emp = employeeService.createEmployee(req);

        return ResponseEntity.ok(
                MapToAPIResponse.ApiResponse(emp, "SUCCESS", "Tạo mới thành công")
        );
    }
}

