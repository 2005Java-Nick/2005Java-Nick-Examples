package com.example.demo;

public class ScoreLessThanZeroException extends Exception {
	
	public static final String MSG = "Score must be at least 0";
	
	public ScoreLessThanZeroException() {
		super(MSG);
	}
	
	public ScoreLessThanZeroException(Throwable cause) {
		super(MSG, cause);
	}
	
	
}
