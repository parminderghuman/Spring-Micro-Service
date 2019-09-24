package com.parminder.gateway.bo;



import org.springframework.lang.NonNull;

public class Student {

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

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
