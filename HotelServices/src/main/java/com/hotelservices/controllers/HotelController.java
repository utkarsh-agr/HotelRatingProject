package com.hotelservices.controllers;

import com.hotelservices.entities.Hotel;
import com.hotelservices.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //adding a hotel into the database
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(this.hotelService.addAHotel(hotel));
    }

    //getting hotel by id
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        return ResponseEntity.ok(this.hotelService.getHotelById(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(this.hotelService.getAllHotels());
    }
}
