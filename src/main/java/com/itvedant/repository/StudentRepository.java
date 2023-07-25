package com.itvedant.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.model.Student;
import com.itvedant.model.StudentWithoutEmail;

@Repository
public interface StudentRepository
	extends CrudRepository<Student, Integer>{
	List<StudentWithoutEmail> findAllProjectedBy();
}
