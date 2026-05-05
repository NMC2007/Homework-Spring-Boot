package com.example.session15.model.dto.request;

import com.example.session15.model.entity.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatusUpdateDTO {

    @NotNull(message = "status không được để trống")
    private OrderStatus status;
}
