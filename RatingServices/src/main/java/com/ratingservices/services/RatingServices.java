package com.ratingservices.services;

import com.ratingservices.entities.Rating;

import java.util.List;

public interface RatingServices {

    //add a rating
    public Rating addRating(Rating rating);

    //get all ratings
    public List<Rating> getAllRatings();

    //get all ratings of a particular user
    public List<Rating> findRatingByUserId(String userId);

    //get all rating of a particular hotel
    public List<Rating> findRatingByHotelId(String hotelId);
}
