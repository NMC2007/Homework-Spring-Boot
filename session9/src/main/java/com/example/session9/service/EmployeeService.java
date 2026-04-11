package com.example.session9.service;

import com.example.session9.model.dto.request.EmployeeCreateDTO;
import com.example.session9.model.entity.Department;
import com.example.session9.model.entity.Employee;
import com.example.session9.repository.DepartmentRepository;
import com.example.session9.repository.EmployeeRepository;
import com.example.session9.validation.DepartmentNotFoundException;
import com.example.session9.validation.DuplicateResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    public Employee createEmployee(EmployeeCreateDTO req) {
        Department depmt = departmentRepository.findById(req.getDepartmentId())
                .orElseThrow(() -> new DepartmentNotFoundException(req.getDepartmentId()));

        if (employeeRepository.existsByEmail(req.getEmail())) {
            throw new DuplicateResourceException("Email đã tồn tại");
        }

        if (employeeRepository.existsByPhone(req.getPhone())) {
            throw new DuplicateResourceException("Số điện thoại đã tồn tại");
        }

        Employee res = new Employee();
        res.setFullName(req.getFullName());
        res.setEmail(req.getEmail());
        res.setPhone(req.getPhone());
        res.setSalary(req.getSalary());
        res.setDepartment(depmt);

        return employeeRepository.save(res);
    }
}
