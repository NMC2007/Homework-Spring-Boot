package com.example.session15.model.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCreateDTO {

    @NotEmpty(message = "Danh sách sản phẩm không được rỗng")
    private List<OrderItemRequestDTO> items;
}
