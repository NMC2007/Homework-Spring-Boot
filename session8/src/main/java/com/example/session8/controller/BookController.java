package com.example.session8.controller;

import com.example.session8.model.dto.request.BookCreateDTO;
import com.example.session8.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@ModelAttribute BookCreateDTO req) {
        return new ResponseEntity<>(bookService.createBook(req), HttpStatus.OK);
    }
}
