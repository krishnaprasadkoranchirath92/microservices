package com.kp.hotel.services;

import java.util.List;

import com.kp.hotel.entities.Hotel;

public interface HotelService {

	Hotel save(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel getById(String id);
}
