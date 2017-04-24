package com.epam.java_training.exception;

public class ExistElementException extends ExceptionClass{
	private static final long serialVersionUID = 1L;
	
	public ExistElementException(String inmsg_error){
		super("[ExistElementException]: The product already exists with such fields and cannot be added. " + inmsg_error);
	}	
}
