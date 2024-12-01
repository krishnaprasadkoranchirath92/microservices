package com.kp.hotel.exceptions;

public class ResouceNotFoundException extends RuntimeException {

	public ResouceNotFoundException(String msg) {
		super(msg);
	}

	public ResouceNotFoundException() {
		super("Resouce not found!");
	}
}
