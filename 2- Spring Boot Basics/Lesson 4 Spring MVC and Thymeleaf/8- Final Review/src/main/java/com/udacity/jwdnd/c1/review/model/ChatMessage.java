package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {

//    private ChatForm chatForm;
    private String username;
    private String messageBody;

    public ChatMessage(String username, String messageBody) {
        this.username = username;
        this.messageBody = messageBody;
    }

    public ChatMessage() {
        this.username = "";
        this.messageBody = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
