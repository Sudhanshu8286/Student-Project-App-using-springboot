package com.itvedant.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public abstract class Student implements List<StudentWithoutEmail> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private Double aggregate;
}
