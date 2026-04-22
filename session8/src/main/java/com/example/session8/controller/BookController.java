package com.example.session8.controller;

import com.example.session8.model.dto.request.BookCreateDTO;
import com.example.session8.model.dto.request.BookUpdateDTO;
import com.example.session8.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@ModelAttribute BookCreateDTO req) {
        return new ResponseEntity<>(bookService.createBook(req), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @Valid @RequestBody BookUpdateDTO reqUpdate) {
        return new ResponseEntity<>(bookService.updateBook(id, reqUpdate), HttpStatus.OK);
    }
}
