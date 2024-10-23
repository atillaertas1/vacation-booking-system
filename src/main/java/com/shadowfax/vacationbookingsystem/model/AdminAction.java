package com.shadowfax.vacationbookingsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "admin_actions")
@Data
public class AdminAction {
    //id,adminID,action_type,vacation_spot_id,timestamp
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private User admin;

    private String actionType; // e.g., "tatil yeri ekleme", "düzenleme", "silme"

    @ManyToOne
    @JoinColumn(name = "vacation_spot_id")
    private VacationSpot vacationSpot;

    private LocalDateTime timestamp;
}
