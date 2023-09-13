package com.technician.Springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.technician.Springboot"})
public class SpringBootBackendServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendServicesApplication.class, args);
	}

}
