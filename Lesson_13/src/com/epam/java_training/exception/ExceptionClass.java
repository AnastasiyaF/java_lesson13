package com.epam.java_training.exception;

public abstract class ExceptionClass extends RuntimeException{
	private String msg_error;
	public static final long serialVersionUID = 1L;
	
	public ExceptionClass(String inmsg_error) {
		super();
		this.msg_error = inmsg_error;
	}

	public String getMessage(){
		return this.msg_error;
	}
}