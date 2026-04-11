package com.example.session9.validation;

import com.example.session9.mapping.MapToAPIResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodNotArgumentException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        });

        return new ResponseEntity<>(
                MapToAPIResponse.ApiResponse(errors, "FAIL", "Dữ liệu không hợp lệ"),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<?> handleDepartmentNotFoundException(DepartmentNotFoundException e) {
        return new ResponseEntity<>(
                MapToAPIResponse.ApiResponse(null, "FAIL", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<?> handleDuplicate(DuplicateResourceException e) {
        return new ResponseEntity<>(
                MapToAPIResponse.ApiResponse(null, "FAIL", e.getMessage()),
                HttpStatus.CONFLICT // 409
        );
    }
}