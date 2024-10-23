package com.shadowfax.vacationbookingsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vacation_spot_images")
@Data
public class VacationSpotImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vacation_spot_id", nullable = false)
    private VacationSpot vacationSpot;

    private String imageUrl;


}

