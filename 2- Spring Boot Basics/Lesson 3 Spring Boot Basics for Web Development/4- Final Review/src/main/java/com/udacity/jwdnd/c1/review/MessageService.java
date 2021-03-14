package com.udacity.jwdnd.c1.review;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MessageService {
    private String message;

    //message is injected
    public MessageService(String message){
        this.message = message;
    }

    @Bean
    public String uppercase() {
        return this.message.toUpperCase();
    }

    @Bean
    public String lowercase(){
        return this.message.toLowerCase();
    }

    //can be added to the construct but it's better practice to add it on a separate message
    //called after initialization of beans in app context
    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating MessageService bean");
    }
}
