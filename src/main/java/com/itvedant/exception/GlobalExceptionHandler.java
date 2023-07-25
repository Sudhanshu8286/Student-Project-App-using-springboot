package com.itvedant.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Global Exception Handler Class
@ControllerAdvice
public class GlobalExceptionHandler 
	extends ResponseEntityExceptionHandler {
	@ExceptionHandler({MyException.class, ArithmeticException.class})
	public ResponseEntity<Object> handleConflict(Exception ex, WebRequest request){
		String response = "Student Not Found";
		return handleExceptionInternal(ex, response, 
						new HttpHeaders(), 
						HttpStatus.NO_CONTENT, 
						request);
	}
}
