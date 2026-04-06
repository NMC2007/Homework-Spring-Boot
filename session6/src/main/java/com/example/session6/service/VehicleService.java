package com.example.session6.service;

import com.example.session6.model.dto.responseDto.VehicleResponse;
import com.example.session6.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public Page<VehicleResponse> getPagedVehicles(int page, int size, String sortBy, String direction, String keyword) {

        // 1. Validate page
        if (page < 0) {
            page = 0;
        }

        // 2. Xử lý sort
        Sort sort = Sort.unsorted();

        if (sortBy != null && !sortBy.trim().isEmpty()
                && direction != null && !direction.trim().isEmpty()) {

            if (direction.equalsIgnoreCase("asc")) {
                sort = Sort.by(sortBy).ascending();
            } else if (direction.equalsIgnoreCase("desc")) {
                sort = Sort.by(sortBy).descending();
            }
        }

        // 3. Pageable
        Pageable pageable = PageRequest.of(page, size, sort);

        return vehicleRepository.findAllByKeyword(keyword, pageable);
    }
}
