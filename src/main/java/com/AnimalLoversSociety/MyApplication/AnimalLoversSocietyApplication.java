package com.AnimalLoversSociety.MyApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main application that runs the program
 * Don't really need to play around with it
 * You can use http://localhost:8080/ to access the HTML page
 * you may be asked to enter a username and password. right now the username is user, password is generated upon running the program, check the console
 */

@SpringBootApplication
public class AnimalLoversSocietyApplication {

	public static void main(String[] args) {

		SpringApplication.run(AnimalLoversSocietyApplication.class, args);


	}



}
