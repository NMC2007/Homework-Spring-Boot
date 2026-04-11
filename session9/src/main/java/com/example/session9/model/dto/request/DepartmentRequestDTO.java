package com.example.session9.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentRequestDTO {
    @Size(min = 5, max = 50, message = "Tên phải từ 5 đến 50 ký tự")
    @NotNull(message = "Tên không được để trống")
    private String name;

    @Size(max = 100, message = "Description không được dài quá 100 ký tự")
    private String description;
}
