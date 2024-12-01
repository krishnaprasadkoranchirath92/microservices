package com.kp.rating.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kp.rating.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {

	List<Rating> findByUsrId(String userId);

	List<Rating> findByHotelId(String hotelId);
}
