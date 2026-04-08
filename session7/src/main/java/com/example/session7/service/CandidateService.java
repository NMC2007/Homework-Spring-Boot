package com.example.session7.service;

import com.example.session7.model.dto.request.CandidateCreateDTO;
import com.example.session7.model.entity.Candidate;
import com.example.session7.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public Candidate createCandidate(CandidateCreateDTO req) {
        Candidate candidate = new Candidate();
        candidate.setFullName(req.getFullName());
        candidate.setEmail(req.getEmail());
        candidate.setAge(req.getAge());
        candidate.setYearsOfExperience(req.getYearsOfExperience());

        return candidateRepository.save(candidate);
    }
}
