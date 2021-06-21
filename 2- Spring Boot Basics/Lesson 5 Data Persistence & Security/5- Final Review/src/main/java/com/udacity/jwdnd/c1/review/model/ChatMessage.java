package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {

//    private ChatForm chatForm;
    private Integer messageid;
    private String username;
    private String messagetext;

    //old constructor
    public ChatMessage(String username, String messagetext) {
        this.username = username;
        this.messagetext = messagetext;
    }

    public ChatMessage(Integer messageid, String username, String messageBody) {
        this.messageid = messageid;
        this.username = username;
        this.messagetext = messageBody;
    }

    public ChatMessage() {
        this.username = "";
        this.messagetext = "";
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageBody() {
        return messagetext;
    }

    public void setMessageBody(String messagetext) {
        this.messagetext = messagetext;
    }
}
