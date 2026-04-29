package com.example.session14.service;

import com.example.session14.model.entity.Employee;
import com.example.session14.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}

