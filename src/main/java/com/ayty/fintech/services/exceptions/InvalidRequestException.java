package com.ayty.fintech.services.exceptions;

public class InvalidRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidRequestException(String msg) {
		super(msg);
	}
	
	public InvalidRequestException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
