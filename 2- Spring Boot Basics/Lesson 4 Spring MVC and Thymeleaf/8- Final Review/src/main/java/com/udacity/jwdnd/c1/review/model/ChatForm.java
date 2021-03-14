package com.udacity.jwdnd.c1.review.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ChatForm {

    private String username;
    private String messageBody;
    private String messageType;

    public ChatForm(String username, String messageType, String messageBody) {
        this.username = username;
        this.messageType = messageType;
        this.messageBody = messageBody;
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

    public void setMessageBody(String messageBody){
        this.messageBody = messageBody;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
