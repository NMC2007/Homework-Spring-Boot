package com.example.session9.controller;

import com.example.session9.mapping.MapToAPIResponse;
import com.example.session9.model.dto.request.DepartmentRequestDTO;
import com.example.session9.model.dto.response.ApiResponse;
import com.example.session9.model.entity.Department;
import com.example.session9.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<?> createDepartment(@Valid @RequestBody DepartmentRequestDTO req) {
        Department dep = departmentService.createDepartment(req);

        return ResponseEntity.ok(MapToAPIResponse.ApiResponse(dep, "SUCCESS", "Tạo mới thành công"));
    }
}
