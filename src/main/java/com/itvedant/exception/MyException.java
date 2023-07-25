package com.itvedant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class MyException extends Exception{
	public MyException(String message) {
		super(message);
	}
}
