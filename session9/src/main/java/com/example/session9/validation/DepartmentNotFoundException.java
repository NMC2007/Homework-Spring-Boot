package com.example.session9.validation;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(Long id) {
        super("Không tìm thấy phòng ban với id = " + id);
    }
}
