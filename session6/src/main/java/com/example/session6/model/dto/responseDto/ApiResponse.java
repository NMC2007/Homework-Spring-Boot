package com.example.session6.model.dto.responseDto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private Boolean success;
    private String message;
    private T data;
}
