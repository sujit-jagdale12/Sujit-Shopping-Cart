package com.customexceptions;

public class NameNotNullException extends RuntimeException{

	public NameNotNullException(String message) {
		super(message);
	}

}
