package com.itvedant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.model.Student;
import com.itvedant.service.StudentService;
import com.itvedant.util.ResponseWrapper;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	private static ResponseWrapper wrapper;
	
	public StudentController() {
		wrapper = new ResponseWrapper();
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		wrapper.setMessage("List of all the students");
		wrapper.setResponse(this.studentService.getAll());
		return new ResponseEntity<>(wrapper, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		Student found = this.studentService.getById(id);
		if(found != null) {
			wrapper.setMessage("Details of the student with ID: " + id);
			wrapper.setResponse(found);
			return new ResponseEntity<>(wrapper,HttpStatus.OK);
		}
		else {
			wrapper.setMessage("Student with ID " + id + " not found");
			wrapper.setResponse(null);
			return new ResponseEntity<>(wrapper,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		wrapper.setMessage("Student Details Added");
		wrapper.setResponse(this.studentService.addStudent(student));
		return new ResponseEntity<>(wrapper, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Integer id,@RequestBody Student student) {
		Student found = this.studentService.getById(id);
		if(found != null) {
			wrapper.setMessage("Details of the student with ID " + id + " updated");
			wrapper.setResponse(this.studentService.updateStudent(id, student));
			return new ResponseEntity<>(wrapper, HttpStatus.OK);
		}
		else {
			wrapper.setMessage("Student with ID " + id + " not found");
			wrapper.setResponse(null);
			return new ResponseEntity<>(wrapper,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
		Student found = this.studentService.getById(id);
		if(found != null) {
			wrapper.setMessage("Details of the student with ID " + id + " updated");
			wrapper.setResponse(this.studentService.deleteStudent(id));
			return new ResponseEntity<>(wrapper, HttpStatus.OK);
		}
		else {
			wrapper.setMessage("Student with ID " + id + " not found");
			wrapper.setResponse(null);
			return new ResponseEntity<>(wrapper,HttpStatus.NOT_FOUND);
		}
	}	

//	@ExceptionHandler({MyException.class})
//	public void handleException() {
//		System.out.println("My Exception");
//	}
}
