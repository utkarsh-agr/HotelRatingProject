package com.ratingservices.services.impl;

import com.ratingservices.entities.Rating;
import com.ratingservices.repositories.RatingRepository;
import com.ratingservices.services.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServicesImpl implements RatingServices {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating addRating(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> findRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> findRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
