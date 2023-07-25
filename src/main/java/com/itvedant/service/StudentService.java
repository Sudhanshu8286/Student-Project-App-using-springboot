package com.itvedant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import com.itvedant.exception.MyException;
import com.itvedant.model.Student;
import com.itvedant.model.StudentWithoutEmail;
import com.itvedant.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
		
//	public Iterable<Student> getAll(){
//		return this.studentRepository.findAll();
//	}
	
	public List<StudentWithoutEmail> getAll(){
		return this.studentRepository.findAllProjectedBy();
	}


	public Student getById(Integer id) {
		return this.studentRepository.findById(id).orElse(null);
	}


	public Student addStudent(Student student) {
		return this.studentRepository.save(student);
	}


	public Student updateStudent(Integer id, Student student) {
			student.setId(id);
			return this.studentRepository.save(student);
	}

	public String deleteStudent(Integer id) {
			this.studentRepository.deleteById(id);
			return "Student Deleted";
	}
}
