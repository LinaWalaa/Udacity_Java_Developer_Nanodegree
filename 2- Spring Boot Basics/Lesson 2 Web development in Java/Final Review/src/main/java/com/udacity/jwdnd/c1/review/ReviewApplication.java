package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Primary
	@Bean
	public String message(){
		System.out.println("I'm here in message!");
		return "Hello";
	}

	@Bean
	//will look for a string bean to get the value from
	public String compoundMessage (String txt){
		System.out.println("I'm here in compound message!, Message received: " + txt);
		return txt + " Spring!";
	}

	@Bean
	//will look for a string bean to get the input value from
	//but if there is more than one Spring will be confused, that's why one has
	//to be annotated primary
	//the same thing would be necessary even if the function is declared below
	//it immediately
	public int characterCount (String text){
		System.out.println(text.length());
		return text.length();
	}
}

