package com.parminder.student.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Student {

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@NonNull
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
