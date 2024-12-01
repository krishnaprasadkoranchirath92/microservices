package com.kp.user.service.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kp.user.service.exceptions.ResourceNotFoundException;
import com.kp.user.service.fiegn.HotelService;
import com.kp.user.service.models.Hotel;
import com.kp.user.service.models.Rating;
import com.kp.user.service.models.UserDetails;
import com.kp.user.service.repositories.UserRepository;
import com.kp.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserDetails saveUser(UserDetails user) {
		String userId = UUID.randomUUID().toString();
		user.setUsrId(userId);
		return userRepo.save(user);
	}

	@Override
	public List<UserDetails> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public UserDetails getUser(String userId) {
		UserDetails userDetails = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException(userId + " not found."));
		Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userDetails.getUsrId(),
				Rating[].class);
		logger.info("{}" + ratings);
		List<Rating> ratingsList = Arrays.stream(ratings).map(rating -> {
//			ResponseEntity<Hotel> hotel = restTemplate
//					.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
			ResponseEntity<Hotel> hotel = hotelService.getHotel(rating.getHotelId());
			logger.info("Response status = {}" + hotel.getStatusCode());
			rating.setHotel(hotel.getBody());
			return rating;
		}).collect(Collectors.toList());
		userDetails.setRatingsList(ratingsList);
		return userDetails;
	}

}
