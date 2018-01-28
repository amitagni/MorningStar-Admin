package com.ms.util;

public class MSException extends Exception {
	private static final long serialVersionUID = -4581740387522086879L;

	public MSException(String message, Throwable cause) {
		super(message, cause);
	}

	public MSException(Throwable cause) {
		super(cause);
	}

	public MSException(String message) {
		super(message);
	}
}