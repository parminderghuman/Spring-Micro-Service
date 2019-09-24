package com.parminder.gateway;



import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.Resources;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.parminder.gateway.bo.Student;
import com.parminder.gateway.client.StudentClient;


@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayServiceApplication{


	public static void main(String[] args) {
        SpringApplication.run(ApiGatewayServiceApplication.class, args);
				
	}
	
	



	@RestController
	class StudentController {

	    private final com.parminder.gateway.client.StudentClient StudentClient;

	    public StudentController(StudentClient StudentClient) {
	        this.StudentClient = StudentClient;
	    }

	    private Collection<Student> fallback() {
	        return new ArrayList<>();
	    }

	    @GetMapping("/students")
	    @CrossOrigin
	    @HystrixCommand(fallbackMethod = "fallback")
	    public Collection<Student> goodStudents() {
	        return StudentClient.readStudents()
	                .getContent();
	                
	                
	    }


	}

}

