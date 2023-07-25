package com.itvedant.util;

import java.util.List;

import com.itvedant.model.Student;
import com.itvedant.model.StudentWithoutEmail;

import lombok.Data;

@Data
public class ResponseWrapper {
	private String message;
	private Object response;
	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setResponse(Student student) {
		// TODO Auto-generated method stub
		
	}

}
