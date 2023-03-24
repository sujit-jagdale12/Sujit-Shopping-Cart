package com.customexceptions;

public class CheckIDException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CheckIDException(String message) {
		super(message);
	}

	
}
