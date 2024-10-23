package com.shadowfax.vacationbookingsystem.repository;

import com.shadowfax.vacationbookingsystem.model.VacationSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationSpotRepository extends JpaRepository<VacationSpot, Long> {
    List<VacationSpot> findByLocationContainingIgnoreCase(String location);
}
