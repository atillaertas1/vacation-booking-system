package com.shadowfax.vacationbookingsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "vacation_spot_id", nullable = false)
    private VacationSpot vacationSpot;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private Status status;


    public enum Status {
        CONFIRMED, PENDING, REJECTED
    }
}
