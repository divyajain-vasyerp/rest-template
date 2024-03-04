package com.example.resttemplate.exception;

public class EmployeeIdNotFoundException extends RuntimeException{

	public EmployeeIdNotFoundException() {
		super();
	}

	public EmployeeIdNotFoundException(String message) {
		super(message);
	}

}
