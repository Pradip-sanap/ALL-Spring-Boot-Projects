package com.jpa.controller;

class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message) {
		super(message);
	}
}

class ConflictException extends RuntimeException {
	public ConflictException(String message) {
		super(message);
	}
}

class UnauthorizedException extends RuntimeException {
	public UnauthorizedException(String message) {
		super(message);
	}
}

class ForbiddenException extends RuntimeException {
	public ForbiddenException(String message) {
		super(message);
	}
}

public class CustomExceptions {

}
