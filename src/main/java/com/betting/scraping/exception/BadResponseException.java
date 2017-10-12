package com.betting.scraping.exception;

public class BadResponseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadResponseException(String messaString) {
		super(messaString);
	}

}
