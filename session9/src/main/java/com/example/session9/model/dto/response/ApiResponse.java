package com.example.session9.model.dto.response;

import lombok.*;

import java.awt.image.PixelGrabber;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
}
