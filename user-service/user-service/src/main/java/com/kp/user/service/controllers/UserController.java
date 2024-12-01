package com.kp.user.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kp.user.service.models.UserDetails;
import com.kp.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails usr) {
		UserDetails user = userService.saveUser(usr);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDetails> getUser(@PathVariable String userId) {
		UserDetails user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<UserDetails>> getAllUsers() {
		List<UserDetails> userList = userService.getAllUsers();
		return ResponseEntity.ok(userList);
	}
}
