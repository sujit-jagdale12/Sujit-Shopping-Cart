package com.customexceptions;

public class CartNotFoundException extends RuntimeException {

	public CartNotFoundException(String message) {
		super(message);
	}

}
