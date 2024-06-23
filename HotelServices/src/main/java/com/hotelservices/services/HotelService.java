package com.hotelservices.services;

import com.hotelservices.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel addAHotel(Hotel hotel);
    Hotel getHotelById(String hotelId);
    List<Hotel> getAllHotels();

}
