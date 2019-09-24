package com.parminder.student;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.parminder.student.bo.Student;
import com.parminder.student.repository.StudentRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class StudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	  @Bean
	    ApplicationRunner init(StudentRepository repository) {
	        return args -> {
	            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
	                    "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
	                repository.save(new Student(name));
	            });
	            repository.findAll().forEach(System.out::println);
	        };
	    }
}
