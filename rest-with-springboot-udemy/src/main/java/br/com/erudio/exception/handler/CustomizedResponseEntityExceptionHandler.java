package br.com.erudio.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import br.com.erudio.exception.ExceptionResponse;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.exception.InvalidJwtAuthenticationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
			new Date(),
			ex.getMessage(),
			request.getDescription(false)
		);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse =
			new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false)
			);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public final ResponseEntity<ExceptionResponse> InvalidJwtAuthenticationException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse =
			new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false)
			);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}