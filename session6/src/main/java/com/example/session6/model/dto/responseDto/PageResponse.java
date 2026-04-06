package com.example.session6.model.dto.responseDto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PageResponse<T> {
    private List<T> items;
    private int page;
    private int size;
    private Long totalItems;
    private int totalPages;
    private Boolean isLast;
}
