package com.shadowfax.vacationbookingsystem.controller;

import com.shadowfax.vacationbookingsystem.model.VacationSpot;
import com.shadowfax.vacationbookingsystem.service.VacationSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/spots")
public class VacationSpotController {

    @Autowired
    private VacationSpotService vacationSpotService;

    @PostMapping
    public ResponseEntity<VacationSpot> createVacationSpot(@RequestBody VacationSpot vacationSpot){
        VacationSpot createdSpot = vacationSpotService.createVacationSpot(vacationSpot);
        return ResponseEntity.ok(createdSpot);
    }

    @GetMapping
    public ResponseEntity<List<VacationSpot>> getAllVacation(){
        List<VacationSpot> vacationSpots = vacationSpotService.getAllVacation();
        return ResponseEntity.ok(vacationSpots);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacationSpot> getVacationSpotById(@PathVariable Long id){
        Optional<VacationSpot> vacationSpot = vacationSpotService.getVacationSpotById(id);

        return vacationSpot.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationSpot> updateVacationSpot(@PathVariable Long id, @RequestBody VacationSpot vacationSpot){
        VacationSpot updateVacationSpot = vacationSpotService.updateVacationSpot(id, vacationSpot);
        return updateVacationSpot != null ? ResponseEntity.ok(updateVacationSpot) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacationSpot(@PathVariable Long id){
        if(vacationSpotService.deleteVacationSpot(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<VacationSpot>> searchVacationSpot(@RequestParam String location){
        List<VacationSpot> vacationSpots = vacationSpotService.searchSpotsByLocation(location);
        return ResponseEntity.ok(vacationSpots);
    }
}
