package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "error-msg")
    private WebElement errorMsg;

    @FindBy(id = "logout-msg")
    private WebElement logoutMsg;

    @FindBy(id = "inputUsername")
    private WebElement inputUsername;

    @FindBy(id = "inputPassword")
    private WebElement inputPassword;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy( id = "signup-link")
    private WebElement signupLink;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public String login(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        submitButton.click();

        try{
            String msg = errorMsg.getText();
            return "Login Failed";
        }catch (Exception e){
            return "Successful login";
        }
    }
}
