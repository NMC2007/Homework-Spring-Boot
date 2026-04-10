package com.example.session7.controller;

import com.example.session7.model.dto.request.CandidateCreateDTO;
import com.example.session7.model.entity.Candidate;
import com.example.session7.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/candidates")
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping("/create")
    public ResponseEntity<?> createCandidates(@Valid @RequestBody CandidateCreateDTO req) {
        Candidate res = candidateService.createCandidate(req);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
