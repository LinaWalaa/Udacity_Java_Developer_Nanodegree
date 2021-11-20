package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@ComponentScan //implicitly added as part of the Springboot app annotation
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

//	@Bean
//	public String message(){
//		System.out.println("Creating message bean");
//		return "Hello, Spring!";
//	}
//
//	//MessageService is injected to this bean
//	//the injected MessageService object is a bean
//	@Bean
//	public String uppercaseMessage(MessageService msg){
//		System.out.println("Creating uppercaseMessage bean");
//		return msg.uppercase();
//	}
//
//	@Bean
//	public String lowercaseMessage(MessageService msg){
//		System.out.println("Creating lowercaseMessage bean");
//		return msg.lowercase();
//	}

}

