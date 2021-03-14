package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class MessageService{
    //private String message;
    public List<ChatMessage> chatMessageList;

    //The PostConstruct annotation is used on a method that needs to
    // be executed after dependency injection is done to perform
    // any initialization. This method MUST be invoked before the
    // class is put into service. This annotation MUST be supported
    // on all classes that support dependency injection.

    @PostConstruct
    public void postConstruct() {

        System.out.println("Creating Message Service Bean");
        this.chatMessageList = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm){

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());

        String bodyText = updateCaseOfMessageBody(chatForm);
        chatMessage.setMessageBody(processBannedWordsInText(bodyText));

        chatMessageList.add(chatMessage);
   }

    public String updateCaseOfMessageBody(ChatForm chatForm) {

        switch (chatForm.getMessageType()) {
            case "Whisper" -> {
                return chatForm.getMessageBody().toLowerCase();
            }
            case "Shout" -> {
                return chatForm.getMessageBody().toUpperCase();
            }
            case "Say" -> {
                return chatForm.getMessageBody();
            }

            default -> throw new IllegalStateException("Unexpected value: " + chatForm.getMessageType());
        }
    }

    public String processBannedWordsInText(String text){
        List<String> bannedWords = new ArrayList<>();
        bannedWords.add("ho");
        bannedWords.add("we");

        if(text.isEmpty())
            return text;

        for (String word : bannedWords) {

            //if (messageBody.contains(word)){
            //searches for a set of chars regardless of the case
            //searches for a certain word in the text

            if (Pattern.compile(Pattern.quote(word), Pattern.CASE_INSENSITIVE).matcher(text).find()){

                //messageBody = messageBody.replace(word,"");

                //replaces the set of chars regardless of the case sensitivity
                //replaced the word in the text with ""

                text = text.replaceAll("(?i)"+word,"");
            }
        }
        return text;
    }

    public List<ChatMessage> getMessages(){
        return new ArrayList<>(this.chatMessageList);
    }

//    //message is injected
//    public MessageService(String message){
//        this.message = message;
//    }
//
//    @Bean
//    public String uppercase() {
//        return this.message.toUpperCase();
//    }
//
//    @Bean
//    public String lowercase(){
//        return this.message.toLowerCase();
//    }
//
//    //can be added to the construct but it's better practice to add it on a separate message
//    //called after initialization of beans in app context
//    @PostConstruct
//    public void postConstruct(){
//        System.out.println("Creating MessageService bean");
//    }
}
