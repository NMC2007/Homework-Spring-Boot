package com.example.session6.model.dto.responseDto;

import com.example.session6.model.entity.VehicleEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VehicleResponse<T> {
    private Long id;
    private String licensePlate;
    private String color;
    private VehicleEnum vehicleType;
}
