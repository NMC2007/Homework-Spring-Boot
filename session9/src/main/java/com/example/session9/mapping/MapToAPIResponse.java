package com.example.session9.mapping;

import com.example.session9.model.dto.response.ApiResponse;

public class MapToAPIResponse {
    public static <T> ApiResponse<T> ApiResponse(T data, String status, String ms) {
        return ApiResponse.<T>builder()
                .status(status)
                .message(ms)
                .data(data)
                .build();
    }
}
