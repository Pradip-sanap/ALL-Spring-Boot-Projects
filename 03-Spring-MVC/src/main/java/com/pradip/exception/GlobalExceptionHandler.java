package com.pradip.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(UserNotFoundException.class) 
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex, HttpServletRequest request) {
		logger.warn("UserNotFoundException: {}", ex.getMessage()); // log warning
		ErrorResponse resp = new ErrorResponse(
				LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(), 
				ex.getMessage(), 
				request.getRequestURI()
		);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}
	
	// Handle validation errors (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationErrors(
			MethodArgumentNotValidException ex,
            HttpServletRequest request ) 	
	{
			String message = ex.getBindingResult()
									.getFieldErrors()
									.stream()
									.map(err -> err.getField() + ": " + err.getDefaultMessage())
									.collect(Collectors.joining(", "));
			
			logger.info("Validation failed: {}", message); // log info
			ErrorResponse error = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				message,
				request.getRequestURI()
			);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
    
    // Handle generic exceptions (fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex, HttpServletRequest request) {
    	logger.error("Unhandled exception at {}: {}", request.getRequestURI(), ex.getMessage(), ex);
    	ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Something went wrong: " + ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
