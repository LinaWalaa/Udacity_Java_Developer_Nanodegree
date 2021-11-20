import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumExample {

    public static void main(String[] args) throws InterruptedException {

        //The first two lines of the script are where we set up the WebDriver.
        //
        //The first line is where we tell the WebDriver manager to make sure
        // we have a Chrome driver set up.
        //Again, this will check the version of Chrome we have running on our computer,
        // and use it to download an appropriate WebDriver instance.
        WebDriverManager.chromedriver().setup();

        //The second line is from Selenium.
        //In it, we're creating a handle for the WebDriver.
        //Note that without the first line, this second line would fail.
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com");
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys("selenium");
        inputField.submit();
        List<WebElement> results = driver.findElements(By.cssSelector("div.g a"));
        for (WebElement element : results) {
            String link = element.getAttribute("href");
            System.out.println(link);
        }
        Thread.sleep(5000);
        driver.quit();
    }

}
