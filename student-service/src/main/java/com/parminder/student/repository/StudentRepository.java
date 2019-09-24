package com.parminder.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.parminder.student.bo.Student;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {
}