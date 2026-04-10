package com.example.session8.service;

import com.example.session8.model.dto.request.BookCreateDTO;
import com.example.session8.model.entity.Book;
import com.example.session8.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book createBook(BookCreateDTO req) {
        try {
//            xử lý lưu file
            MultipartFile file = req.getCoverImage();
            String fileName = null;

            if (file != null && !file.isEmpty()) {
                String uploadDir = "D:\\data\\Code\\SpringBoot\\FileDatabase";

                fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

                Path path = Paths.get(uploadDir, fileName);
                Files.write(path, file.getBytes());
            }

//            convert sang entity
            Book newBook = new Book();
            newBook.setAuthor(req.getAuthor());
            newBook.setTitle(req.getTitle());
            newBook.setStock(req.getStock());
            newBook.setCoverUrl(fileName);
            bookRepository.save(newBook);

            return newBook;

        } catch (IOException e) {
            throw new RuntimeException("Upload file lỗi");
        }
    }
}