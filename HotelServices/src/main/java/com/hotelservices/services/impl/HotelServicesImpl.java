package com.hotelservices.services.impl;

import com.hotelservices.entities.Hotel;
import com.hotelservices.exceptions.ResourceNotFoundException;
import com.hotelservices.repositories.HotelRepository;
import com.hotelservices.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServicesImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel addAHotel(Hotel hotel) {
        hotel.setHotelId(UUID.randomUUID().toString());
        return this.hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return this.hotelRepository.findById(hotelId).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return this.hotelRepository.findAll();
    }
}
