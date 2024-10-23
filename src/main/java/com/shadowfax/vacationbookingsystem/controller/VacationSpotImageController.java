package com.shadowfax.vacationbookingsystem.controller;

import com.shadowfax.vacationbookingsystem.model.VacationSpotImage;
import com.shadowfax.vacationbookingsystem.service.VacationSpotImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spots/{spotId}/images")
public class VacationSpotImageController {

    @Autowired
    private VacationSpotImageService vacationSpotImageService;

    @PostMapping
    public ResponseEntity<VacationSpotImage> addImage(@PathVariable Long spotId, @RequestBody VacationSpotImage image) {
        VacationSpotImage createdImage = vacationSpotImageService.addImage(spotId, image);
        return ResponseEntity.ok(createdImage);
    }

    @GetMapping
    public ResponseEntity<List<VacationSpotImage>> getAllImagesBySpot(@PathVariable Long spotId) {
        List<VacationSpotImage> images = vacationSpotImageService.getImagesBySpotId(spotId);
        return ResponseEntity.ok(images);
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long imageId) {
        if (vacationSpotImageService.deleteImage(imageId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}