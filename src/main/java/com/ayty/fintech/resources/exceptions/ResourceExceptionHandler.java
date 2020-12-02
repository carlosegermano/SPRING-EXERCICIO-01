package com.ayty.fintech.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ayty.fintech.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
		StandardError ste = new StandardError(HttpStatus.NOT_FOUND.value(), "Objeto não encontrado", exception.getMessage(), System.currentTimeMillis(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ste);
	}
	
	
}
