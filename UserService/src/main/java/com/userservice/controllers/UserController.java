package com.userservice.controllers;

import com.userservice.entities.User;
import com.userservice.services.UserServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices userServices;

    private final Logger logger= LoggerFactory.getLogger(UserController.class);

    //save a user
    @PostMapping
    public ResponseEntity<User> saveAUser(@RequestBody User user){
        User returnedUser=this.userServices.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnedUser);
    }

    //get a user with userId
    @GetMapping("/{userId}")
    @CircuitBreaker(name="UserCallingHotelRatingServiceBreaker",fallbackMethod = "ratingHotelFallbackMethodUser")
    @RateLimiter(name = "rateLimiterToGetUser", fallbackMethod = "ratingHotelFallbackMethodUser")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        return ResponseEntity.ok(this.userServices.getUserById(userId));
    }



    @GetMapping
    @Retry(name = "ratingHotelCallFromUserRetry", fallbackMethod = "ratingHotelFallbackMethod")
    public ResponseEntity<List<User>> getAllUsers(){
        logger.info("I am trying to get all users ratings....");
        return ResponseEntity.ok(this.userServices.getAllUsers());
    }

    //creating fallback method with same return type as the one due to whom it is called
    public ResponseEntity<User> ratingHotelFallbackMethodUser(String userId,Exception ex){
        logger.info("Fallback method is executing because some service is not running: {}", ex.getMessage());
        User user=User.builder().name("FallbackName").id("FallbackId").email("FallbackEmail").about("This dummy data is coming because one of your service is not up").build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(user);
    }

    public ResponseEntity<List<User>> ratingHotelFallbackMethod(Exception ex){
        logger.info("cannot reach sorry :( : {}", ex.getMessage());
        User user=User.builder().name("FallbackName").id("FallbackId").email("FallbackEmail").about("This dummy data is coming because one of your service is not up").build();
        List<User> users=new ArrayList<>();
        users.add(user);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(users);
    }

}
