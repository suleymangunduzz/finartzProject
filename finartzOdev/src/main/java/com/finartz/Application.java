package com.finartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//this tag means that is a spring boot application and
//and you can start the server with Runing this class.
@SpringBootApplication
public class Application {

	/*
	 * Since i am using Spring Boot, Mongodb configuration is read from application.properties
	 * insted of applicationContext.xml
	 * 
	 * */
	
	public static void main(String[] args) {
	
		SpringApplication.run(Application.class, args);
	}
}