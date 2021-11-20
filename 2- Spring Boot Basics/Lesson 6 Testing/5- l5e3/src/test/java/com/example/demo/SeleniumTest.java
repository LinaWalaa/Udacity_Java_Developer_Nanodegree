package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SeleniumTest {

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        //open in an incognito mode
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("incognito");
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//
//        WebDriver driver = new ChromeDriver(capabilities);

        WebDriver driver = new ChromeDriver();

        //delete cache and cookies
//        driver.manage().deleteAllCookies();
//        driver.get("chrome://settings/clearBrowserData");
//        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);

        driver.get("http://localhost:8080/animal");

        WebElement inputField = driver.findElement(By.id("animalText"));
        inputField.sendKeys("Giraffe");
        System.out.println(inputField.getText());

        inputField = driver.findElement(By.id("adjective"));
        inputField.sendKeys("tall");

        List<WebElement> trainingResults = driver.findElements(By.className("trainingMessage"));
        System.out.println(trainingResults.size());

        //to show training msgs
//        for (WebElement msg: trainingResults) {
//            System.out.println(msg.getText());
//        }

//        inputField.submit();

        //we only iterate over the submit because we don't clear the
        // input fields after each submit
        for(int i=0; i<5; i++){

            // We are re-assigning the inputField because this
            // element gets removed from the DOM structure after
            // each iteration.
            // Otherwise, you'll get
            // org.openqa.selenium.StaleElementReferenceException
            // at runtime.
            inputField = driver.findElement(By.id("adjective"));
            inputField.submit();
            //same as input.submit()
//            driver.findElement(By.id("submit")).click();

            //we are reassigning it, because it gets removed
            // from DOM structure after
            //each iteration. so we can print its text values
            // and the value needs to be updated either
            // way with each submission
            trainingResults = driver.findElements(By.className("trainingMessage"));
            System.out.println(trainingResults.size());

            //to show training msgs
//            for (WebElement msg: trainingResults) {
//                System.out.println(msg.getText());
//            }

        }

        try {
            WebElement conclusionResult = driver.findElement(By.className("conclusionMessage"));
            System.out.println(conclusionResult.getText());
        } catch (Exception e) {
            //exception is thrown only when the iterations < 5
//            e.printStackTrace();
//            System.out.println("Less than 5 lines are submitted!");
            System.out.println("Only " + (trainingResults.size()-1) + " lines are submitted!");
        }
        
        Thread.sleep(5000);
        driver.quit();


    }
}
