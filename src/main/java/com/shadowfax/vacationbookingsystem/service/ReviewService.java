package com.shadowfax.vacationbookingsystem.service;

import com.shadowfax.vacationbookingsystem.model.Review;
import com.shadowfax.vacationbookingsystem.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        return optionalReview.orElse(null);
    }

    public Review updateReview(Long id, Review reviewDetails) {
        Optional<Review> optionalReview = reviewRepository.findById(id);

        if(optionalReview.isPresent()){
            Review existingReview = optionalReview.get();

            existingReview.setVacationSpot(reviewDetails.getVacationSpot());
            existingReview.setUser(reviewDetails.getUser());
            existingReview.setRating(reviewDetails.getRating());
            existingReview.setComment(reviewDetails.getComment());

            return reviewRepository.save(existingReview);
        }

        return null;
    }

    public boolean deleteReview(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);

        if (optionalReview.isPresent()){
            reviewRepository.delete(optionalReview.get());
            return true;
        }
        return false;
    }
}
