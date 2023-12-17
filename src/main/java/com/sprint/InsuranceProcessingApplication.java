package com.sprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/***************************************************************************************
* Main class for the Insurance Processing Web Application.
* 
* @SpringBootApplication indicates that this class is the starting point of the Spring Boot application.
* @EnableJpaRepositories enables JPA repositories for data access.
* @EntityScan specifies the base packages to scan for JPA entities.
***************************************************************************************/

@EnableJpaRepositories(basePackages = {"com.app.repository"})
@EntityScan(basePackages = {"com.app.entity"})
@SpringBootApplication(scanBasePackages = {"com.app.controller","com.app.dto","com.app.globalexception","com.app.service"})

public class InsuranceProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceProcessingApplication.class, args);
		System.out.println("Welcome to Insurance Processing Web Application!!");
	}

}
