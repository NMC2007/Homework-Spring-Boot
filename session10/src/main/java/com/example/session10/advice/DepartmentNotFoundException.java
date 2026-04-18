package com.example.session10.advice;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(Long id) {
        super("Không tìm thấy id = " + id);
    }
}
