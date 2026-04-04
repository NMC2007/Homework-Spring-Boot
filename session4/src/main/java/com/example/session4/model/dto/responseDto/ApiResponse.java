package com.example.session4.model.dto.responseDto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private String message;
    private boolean status;
    private T data;
}
