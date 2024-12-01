package com.kp.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.hotel.entities.Hotel;
import com.kp.hotel.exceptions.ResouceNotFoundException;
import com.kp.hotel.repositories.HotelRepository;
import com.kp.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel save(Hotel hotel) {
		hotel.setHotelId(UUID.randomUUID().toString());
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getById(String id) {
		return hotelRepo.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Hotel with given id not present"));
	}

}
