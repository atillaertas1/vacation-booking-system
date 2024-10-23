package com.shadowfax.vacationbookingsystem.repository;

import com.shadowfax.vacationbookingsystem.model.VacationSpotImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationSpotImageRepository extends JpaRepository<VacationSpotImage, Long> {
    List<VacationSpotImage> findByVacationSpotId(Long spotId);
}
