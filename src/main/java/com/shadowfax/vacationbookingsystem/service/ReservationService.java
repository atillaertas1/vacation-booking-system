package com.shadowfax.vacationbookingsystem.service;

import com.shadowfax.vacationbookingsystem.model.Reservation;
import com.shadowfax.vacationbookingsystem.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    public ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }


    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        Optional<Reservation> optionalReservation= reservationRepository.findById(id);
        return optionalReservation.orElse(null);
    }


    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);

        if(optionalReservation.isPresent()){
            Reservation existingReservation = optionalReservation.get();

            existingReservation.setStartDate(reservationDetails.getStartDate());
            existingReservation.setEndDate(reservationDetails.getEndDate());
            existingReservation.setTotalPrice(reservationDetails.getTotalPrice());
            existingReservation.setVacationSpot(reservationDetails.getVacationSpot());
            existingReservation.setUser(reservationDetails.getUser());
            existingReservation.setStatus(reservationDetails.getStatus());

            return reservationRepository.save(existingReservation);
        }
        return null;
    }

    public boolean deleteReservation(Long id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()){
            reservationRepository.delete(optionalReservation.get());
            return true;
        }
        return false;
    }
}
