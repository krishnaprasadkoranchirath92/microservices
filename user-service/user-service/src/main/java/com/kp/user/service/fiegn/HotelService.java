package com.kp.user.service.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kp.user.service.models.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("/hotels/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable("id") String id);
}
