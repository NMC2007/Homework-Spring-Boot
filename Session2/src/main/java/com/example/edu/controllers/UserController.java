package com.example.edu.controllers;

import com.example.edu.models.User;
import com.example.edu.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> findAllUser() {
        List<User> UsersList = userService.findAll();
        if (UsersList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(UsersList, HttpStatus.OK);
    }

    @GetMapping("/search-user")
    public ResponseEntity<?> findByName(@RequestParam String keyword) {
        List<User> userList = userService.findByString(keyword);
        if (userList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
