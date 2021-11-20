package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ChatPage {

    @FindBy(id = "logout")
    private WebElement logoutButton;

    @FindBy(id = "inputMessageType")
    private WebElement inputMessageType;

    @FindBy(id = "inputMessageText")
    private WebElement inputMessageText;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "username")
    private List<WebElement> usernames;

    @FindBy(id = "chat-message")
    private List<WebElement> chatMessages;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public ChatMessage sendMessage(String msgType, String msgText){
        inputMessageType.sendKeys(msgType);
        inputMessageText.sendKeys(msgText);
        submitButton.click();

//        ArrayList<String> lastMsg = null;
//        lastMsg = new ArrayList<>();
        ChatMessage lastChatMessage = new ChatMessage();

        try{
//            lastMsg.add(usernames.get(usernames.size()-1).getText());
//            lastMsg.add(chatMessages.get(chatMessages.size()-1).getText());
//            System.out.println("sucess");
//            return lastMsg;
            lastChatMessage.setUsername(usernames.get(usernames.size()-1).getText());
            lastChatMessage.setMessageBody(chatMessages.get(chatMessages.size()-1).getText());
            return lastChatMessage;
        }catch (Exception e){
            //return null
//            System.out.println("fail");
//            return lastMsg;
            return null;
        }

    }

    public ChatMessage getLastMessage(){

//        ArrayList<String> lastMsg = null;
//        lastMsg = new ArrayList<>();
        ChatMessage lastChatMessage = new ChatMessage();

        try{
//            lastMsg.add(usernames.get(usernames.size()-1).getText());
//            lastMsg.add(chatMessages.get(chatMessages.size()-1).getText());
//            System.out.println("sucess");
//            return lastMsg;
            lastChatMessage.setUsername(usernames.get(usernames.size()-1).getText());
            lastChatMessage.setMessageBody(chatMessages.get(chatMessages.size()-1).getText());
            return lastChatMessage;
        }catch (Exception e){
            //return null
//            System.out.println("fail");
//            return lastMsg;
            return null;
        }

    }
}
