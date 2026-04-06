package com.example.session6.repository;

import com.example.session6.model.dto.responseDto.VehicleResponse;
import com.example.session6.model.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("""
        select new com.example.session6.model.dto.responseDto.VehicleResponse(
            v.id, v.licensePlate, v.color, v.type
        )
        from Vehicle v
        where (:keyword is null or :keyword = '' 
            or lower(v.licensePlate) like lower(concat('%', :keyword, '%'))
            or lower(v.color) like lower(concat('%', :keyword, '%'))
            or lower(v.type) like lower(concat('%', :keyword, '%'))
        )
    """)
    Page<VehicleResponse> findAllByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
