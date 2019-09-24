package com.parminder.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import com.parminder.gateway.bo.Student;
import org.springframework.hateoas.Resources;

@FeignClient("student-service")
public interface StudentClient {
	
    @GetMapping("/students")
    @CrossOrigin
    Resources<Student> readStudents();
}
