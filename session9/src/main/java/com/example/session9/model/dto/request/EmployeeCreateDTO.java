package com.example.session9.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EmployeeCreateDTO {
    @Size(min = 5, max = 50, message = "Tên phải từ 5 đến 50 ký tự")
    @NotNull(message = "Tên không được để trống")
    private String fullName;

    @Email(message = "Email không hợp lệ")
    private String email;

    @Pattern(
            regexp = "^(03|05|07|08|09)\\d{8}$",
            message = "Số điện thoại không hợp lệ"
    )
    private String phone;

    @Min(value = 5000000, message = "Lương phải >= 5,000,000")
    @NotNull(message = "Lương không được để trống")
    private BigDecimal salary;

    @NotNull(message = "Department không được để trống")
    private Long departmentId;
}
