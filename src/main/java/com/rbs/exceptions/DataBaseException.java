package com.rbs.exceptions;

public class DataBaseException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public DataBaseException(String message, Throwable throwable) {
		super(message, throwable);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
