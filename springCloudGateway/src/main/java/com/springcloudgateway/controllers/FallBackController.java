package com.springcloudgateway.controllers;

import com.springcloudgateway.externalServices.ApiGatewayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class FallBackController {

    Logger logger= LoggerFactory.getLogger(FallBackController.class);


    @GetMapping("/inCaseOfUserServiceDown")
    public List<Object> fallBackOfUserService(String userId) {
        logger.info("fallBackOfUserService");
        return new ArrayList<>();
    }

    @GetMapping("/inCaseOfHotelServiceDown")
    public Object fallBackOfHotelService(String hotelId) {
        logger.info("fallBackOfHotelService");
        return null;
    }

    @GetMapping("/inCaseOfRatingServiceDown")
    public Object fallBackOfRatingService(String ratingId) {
        logger.info("fallBackOfRatingService");
        return null;
    }

}
