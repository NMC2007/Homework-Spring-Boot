package com.example.session14.controller;

import com.example.session14.model.dto.request.UserCreateDTO;
import com.example.session14.model.dto.request.UserLoginDTO;
import com.example.session14.model.entity.User;
import com.example.session14.principal.UserPrincipal;
import com.example.session14.security.CustomUserDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final CustomUserDetailsService customUserDetailsService;
    private final AuthenticationManager authenticationManager;

    @GetMapping
    public String test() {
        return "Auth API public OK";
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO req) {
        User rep = customUserDetailsService.createUser(req);
        return new ResponseEntity<>(rep, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO req) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getUsername(),
                            req.getPassword()
                    )
            );

            // nếu chạy được tới đây => login thành công
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

            return ResponseEntity.ok(userPrincipal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("username or password incorrect");
        }
    }
}
