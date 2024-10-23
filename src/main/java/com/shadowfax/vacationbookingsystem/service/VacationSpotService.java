package com.shadowfax.vacationbookingsystem.service;

import com.shadowfax.vacationbookingsystem.model.VacationSpot;
import com.shadowfax.vacationbookingsystem.repository.VacationSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacationSpotService {

    @Autowired
    VacationSpotRepository vacationSpotRepository;

    public VacationSpot createVacationSpot(VacationSpot vacationSpot) {
       return vacationSpotRepository.save(vacationSpot);
    }

    public List<VacationSpot> getAllVacation() {
        return vacationSpotRepository.findAll();
    }

    public Optional<VacationSpot> getVacationSpotById(Long id) {
        return vacationSpotRepository.findById(id);
    }

    public VacationSpot updateVacationSpot(Long id, VacationSpot vacationSpotDetails) {
        Optional<VacationSpot> optionalVacationSpot = vacationSpotRepository.findById(id);
        if (optionalVacationSpot.isPresent()){
            VacationSpot existingVacationSpot = optionalVacationSpot.get();

            existingVacationSpot.setName(vacationSpotDetails.getName());
            existingVacationSpot.setDescription(vacationSpotDetails.getDescription());
            existingVacationSpot.setLocation(vacationSpotDetails.getLocation());
            existingVacationSpot.setPricePerNight(vacationSpotDetails.getPricePerNight());
            existingVacationSpot.setAvailabilityStartDate(vacationSpotDetails.getAvailabilityStartDate());
            existingVacationSpot.setAvailabilityEndDate(vacationSpotDetails.getAvailabilityEndDate());
            existingVacationSpot.setImageUrl(vacationSpotDetails.getImageUrl());

            return vacationSpotRepository.save(existingVacationSpot);
        }
        return null;
    }

    public boolean deleteVacationSpot(Long id) {
        Optional<VacationSpot> optionalVacationSpot = vacationSpotRepository.findById(id);

        if (optionalVacationSpot.isPresent()){
            vacationSpotRepository.delete(optionalVacationSpot.get());
            return true;
        }
        return false;
    }


    public List<VacationSpot> searchSpotsByLocation(String location) {
        return vacationSpotRepository.findByLocationContainingIgnoreCase(location);
    }


}
