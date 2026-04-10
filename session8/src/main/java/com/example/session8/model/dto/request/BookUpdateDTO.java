package com.example.session8.model.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateDTO {
    @Min(value = 0, message = "Stock không được bé hơn 0")
    private int stock;
}
