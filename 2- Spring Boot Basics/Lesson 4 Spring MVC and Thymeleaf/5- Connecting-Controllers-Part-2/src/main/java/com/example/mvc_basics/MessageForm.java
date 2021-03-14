package com.example.mvc_basics;


// we need this class to store the form data for our request
public class MessageForm {
    private String text;

    public MessageForm(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
