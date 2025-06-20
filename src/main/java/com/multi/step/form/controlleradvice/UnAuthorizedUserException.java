package com.multi.step.form.controlleradvice;

public class UnAuthorizedUserException extends RuntimeException {
	public UnAuthorizedUserException(String message) {
		super(message);
	}
}
