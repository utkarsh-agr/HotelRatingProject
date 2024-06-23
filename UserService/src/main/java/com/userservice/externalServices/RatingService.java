package com.userservice.externalServices;


import com.userservice.payloads.Rating.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/user/{userId}")
    ResponseEntity<List<Rating>> getRatingsOfUser(@PathVariable("userId") String userId);
}
