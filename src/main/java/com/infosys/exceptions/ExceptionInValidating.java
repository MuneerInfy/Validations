package com.infosys.exceptions;

public class ExceptionInValidating extends Exception {

	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	String message="Error in Validating the user details.Please check in the Service class";
	public ExceptionInValidating(String message) {
		
		super(message);
	}

}
