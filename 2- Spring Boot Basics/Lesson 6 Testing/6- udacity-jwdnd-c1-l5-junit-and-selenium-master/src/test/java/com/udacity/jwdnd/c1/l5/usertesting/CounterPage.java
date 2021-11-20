package com.udacity.jwdnd.c1.l5.usertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//The goal of a Page Object is to simplify and abstract away common
// Selenium tasks, like finding elements on the page.
public class CounterPage {

    //Defining Element Selectors

    @FindBy(id = "count-display")
    private WebElement countDisplay;
    //instead of the below line
//    WebElement countDisplay = driver.findElement(By.id("count-display"));

    @FindBy(id = "increment-button")
    private WebElement incrementButton;

    @FindBy(id = "reset-value-field")
    private WebElement resetValueField;

    @FindBy(id = "reset-button")
    private WebElement resetButton;

    //Initializing Elements in the Constructor
    public CounterPage(WebDriver driver) {
        //we declare a WebDriver as the only constructor argument,
        // and we call PageFactory.initElements() with the driver and
        // the "this" keyword as arguments.
        // This is shorthand to tell Selenium to use the given driver
        // to initialize the @FindBy-annotated fields in the class.

        // In principle, we could do this somewhere else, but as we'll
        // see in the next video, initializing a Page Object in its constructor
        // like this is pretty flexible and clean.
        PageFactory.initElements(driver, this);
    }

    //the goal of writing these helpers is to separate
    // the action taken on the class from the specific element
    // interactions required to fulfill that action.

    //Creating Helper Methods
    public int getDisplayedCount() {
        return Integer.parseInt(countDisplay.getText());
    }

    public void incrementCount() {
        incrementButton.click();
    }

    public void resetCount(int value) {
        resetValueField.clear();
        resetValueField.sendKeys(String.valueOf(value));
        resetButton.click();
    }
}
