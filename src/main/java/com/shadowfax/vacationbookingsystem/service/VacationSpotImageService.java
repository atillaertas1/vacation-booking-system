package com.shadowfax.vacationbookingsystem.service;

import com.shadowfax.vacationbookingsystem.model.VacationSpot;
import com.shadowfax.vacationbookingsystem.model.VacationSpotImage;
import com.shadowfax.vacationbookingsystem.repository.VacationSpotImageRepository;
import com.shadowfax.vacationbookingsystem.repository.VacationSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacationSpotImageService {

    @Autowired
    private VacationSpotImageRepository vacationSpotImageRepository;

    @Autowired
    private VacationSpotRepository vacationSpotRepository;

    public VacationSpotImage addImage(Long spotId, VacationSpotImage image) {
        Optional<VacationSpot> vacationSpotOptional = vacationSpotRepository.findById(spotId);

        if (vacationSpotOptional.isPresent()) {
            VacationSpot vacationSpot = vacationSpotOptional.get();
            image.setVacationSpot(vacationSpot);
            return vacationSpotImageRepository.save(image);
        } else {
            throw new RuntimeException("Vacation spot not found with id: " + spotId);
        }
    }

    public List<VacationSpotImage> getImagesBySpotId(Long spotId) {
        return vacationSpotImageRepository.findByVacationSpotId(spotId);
    }

    public boolean deleteImage(Long imageId) {
        Optional<VacationSpotImage> imageOptional = vacationSpotImageRepository.findById(imageId);

        if (imageOptional.isPresent()) {
            vacationSpotImageRepository.deleteById(imageId);
            return true; // Başarılı silme işlemi
        } else {
            return false; // Resim bulunamadıysa
        }
    }
}
