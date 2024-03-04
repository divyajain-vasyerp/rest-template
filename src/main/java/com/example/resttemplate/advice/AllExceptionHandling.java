package com.example.resttemplate.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.resttemplate.dto.ApiResponseDTO;
import com.example.resttemplate.exception.EmployeeIdNotFoundException;

@RestControllerAdvice
public class AllExceptionHandling {

	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ApiResponseDTO employeeIdNotFoundException(EmployeeIdNotFoundException e)
	{
		return new ApiResponseDTO(404,"error",e.getMessage());
	}
}
