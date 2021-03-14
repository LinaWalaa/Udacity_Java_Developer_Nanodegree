package com.udacity.jdnd.SpringIocConfigurationDemoApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
//This is a convenience annotation that is equivalent to
// declaring @Configuration, @EnableAutoConfiguration and @ComponentScan.
@Configuration
//
@AutoConfigurationPackage
public class SpringIocConfigurationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIocConfigurationDemoApplication.class, args);
	}

	@Bean
	public static String basicMessage(){
		System.out.println("inside basicMessage");
		return "Hello";
	}

	@Bean
	@Primary
	public static String compoundMessage(String basicMessage){
		System.out.println("inside compoundMessage, received: " + basicMessage);
		return basicMessage + ", Spring!";
	}

	@Bean
	//receives compound message because of the @Primary annotation
	public static int charachterCount(String message){
		System.out.println("inside charachterCount, received: " + message);
		return message.length();
	}
	
}
