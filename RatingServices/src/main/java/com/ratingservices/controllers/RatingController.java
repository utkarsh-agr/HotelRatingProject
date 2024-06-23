package com.ratingservices.controllers;

import com.ratingservices.entities.Rating;
import com.ratingservices.services.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingServices ratingServices;

    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.addRating(rating));
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<List<Rating>> getRating(@PathVariable String ratingId) {
        return ResponseEntity.ok(ratingServices.getAllRatings());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingServices.findRatingByUserId(userId));
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingServices.findRatingByHotelId(hotelId));
    }

}
