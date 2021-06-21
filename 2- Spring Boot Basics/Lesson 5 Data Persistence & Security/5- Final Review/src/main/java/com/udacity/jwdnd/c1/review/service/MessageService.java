package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessagesMapper;
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
//    public List<ChatMessage> messageList;
    private MessagesMapper messageMapper;

    //The PostConstruct annotation is used on a method that needs to
    // be executed after dependency injection is done to perform
    // any initialization. This method MUST be invoked before the
    // class is put into service. This annotation MUST be supported
    // on all classes that support dependency injection.

    public MessageService(MessagesMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void postConstruct() {

        System.out.println("Creating ChatMessage Service Bean");
//        this.messageList = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm){

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());

        String bodyText = updateCaseOfMessageBody(chatForm);
        chatMessage.setMessageBody(processBannedWordsInText(bodyText));

        messageMapper.addMessage(chatMessage);
//        messageList.add(chatMessage);
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
        return messageMapper.getAllMessages();
//        return new ArrayList<>(this.messageList);
    }
}

