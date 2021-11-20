package com.udacity.jwdnd.c1.l5.usertesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;


//@SpringBoot annotation at the top of the class allows Spring to
// start our application when the tests are run.
//There's also an argument to the annotation which specifies that the
// server should be run on a random port.

//This is useful when there's the possibility that another
// instance of the server might be running at the same time,
// which is often the case in development or testing environments.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserTestingApplicationTests {

    //using a random port means that  we need to know what that random port is.
    //Spring allows us to inject it into this class using the @LocalServerPort
    // annotation.
    //This allows us to use it with driver.get to make sure we're pointing
    // at the right instance of our server.
    @LocalServerPort
    private Integer port;

    private static WebDriver driver;
    private CounterPage counter;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    //We have an instance level CounterPage field that is initialized in
    // our beforeEach method.
    //This method also navigates to the counter URL, which means that
    // every test will start from the same base page.
    @BeforeEach
    public void beforeEach() {
        driver.get("http://localhost:" + port + "/counter");
        counter = new CounterPage(driver);
    }

    @Test
    public void testIncrement() {
        int prevValue = counter.getDisplayedCount();
        counter.incrementCount();
        assertEquals(prevValue + 1, counter.getDisplayedCount());
    }

    @Test
    public void testIncrementTenTimes() {
        int prevValue = counter.getDisplayedCount();
        for (int i = 0; i < 10; i++) {
            assertEquals(prevValue + i, counter.getDisplayedCount());
            counter.incrementCount();
        }
    }

    @Test
    public void testReset() {
        counter.resetCount(10);
        assertEquals(10, counter.getDisplayedCount());
        counter.resetCount(0);
        assertEquals(0, counter.getDisplayedCount());
    }

}
