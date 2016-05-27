package com.rbs.exceptions;

public class RbsException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public RbsException(String message, Throwable throwable) {
		super(message, throwable);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
