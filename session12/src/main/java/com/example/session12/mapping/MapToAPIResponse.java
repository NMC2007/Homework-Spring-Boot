package com.example.session12.mapping;

import com.example.session12.model.dto.response.ApiResponse;

import java.time.LocalDateTime;

public class MapToAPIResponse {
    public static <T> ApiResponse<T> mapTo(T data, int status, String info) {
        return ApiResponse.<T>builder()
                .status(status)
                .info(info)
                .data(data)
                .time(LocalDateTime.now())
                .build();
    }
}
