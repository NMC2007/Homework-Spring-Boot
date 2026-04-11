package com.example.session9.service;

import com.example.session9.model.dto.request.DepartmentRequestDTO;
import com.example.session9.model.entity.Department;
import com.example.session9.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department createDepartment(DepartmentRequestDTO req) {
        Department dep = new Department();

        dep.setName(req.getName());
        dep.setDescription(req.getDescription());

        return departmentRepository.save(dep);
    }
}
