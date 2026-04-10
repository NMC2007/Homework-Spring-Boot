package com.example.session8.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class BookCreateDTO {
    private String title;
    private String author;
    private int stock;
    private MultipartFile coverImage;
}
