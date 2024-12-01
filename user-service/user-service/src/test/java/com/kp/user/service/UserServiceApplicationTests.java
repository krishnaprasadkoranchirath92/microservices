package com.kp.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.kp.user.service.fiegn.RatingService;
import com.kp.user.service.models.Rating;

@SpringBootTest
class UserServiceApplicationTests {
	@Autowired
	private RatingService ratingservice;

	@Test
	void contextLoads() {
	}
	
	@Test
	void createRating() {
		Rating rating = Rating.builder().rating(10).usrId("5407952f-765a-42ee-b5d6-2d8676f5048c")
				.hotelId("6cadc63f-4268-4c40-8c37-df41f2e0d077").feedback("Excellent!").build();
		ResponseEntity<Rating> savedRating = ratingservice.createRating(rating);
		System.out.println("Rating saved" + savedRating.getBody());
	}

}
