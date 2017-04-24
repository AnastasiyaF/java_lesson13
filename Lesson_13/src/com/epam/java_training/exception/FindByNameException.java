package com.epam.java_training.exception;

public class FindByNameException extends ExceptionClass {
	public static final long serialVersionUID = 1L;
	
	public FindByNameException(String inmsg_error){
		super("[FindByNameException]: There are not records with field = " + inmsg_error);
	}

}