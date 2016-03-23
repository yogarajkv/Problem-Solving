package com.garding.exception;

public class GradeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GradeException(String message)
	{
		super(message);
	}
	
	
	public GradeException(Throwable t)
	{
		super(t);		
	}

}
