package com.kp.user.service.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kp.user.service.models.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@PostMapping(path = "/ratings")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating);

	@PutMapping(path = "/rating/{ratingId}")
	public Rating updateRating(@PathVariable String ratingId, @RequestBody Rating rating);

	@DeleteMapping(path = "/rating/{ratingId}")
	public Rating deleteRating(@PathVariable String ratingId);
}
