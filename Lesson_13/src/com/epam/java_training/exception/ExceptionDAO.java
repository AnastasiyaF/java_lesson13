package com.epam.java_training.exception;

public class ExceptionDAO extends ExceptionClass{
	private static final long serialVersionUID = 1L;
	
	public ExceptionDAO(String inmsg_error){
		super("[ExceptionDAO]: " + inmsg_error);
	}	
	
}
