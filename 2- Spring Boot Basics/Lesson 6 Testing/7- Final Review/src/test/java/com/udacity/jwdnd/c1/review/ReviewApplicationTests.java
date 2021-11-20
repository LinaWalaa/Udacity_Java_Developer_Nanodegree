package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {

	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private static LoginPage loginPage;
	private static SignupPage signupPage;
	private static ChatPage chatPage;
	private String baseURL;

	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		signupPage = new SignupPage(driver);
		loginPage = new LoginPage(driver);
		chatPage = new ChatPage(driver);
	}

	@AfterAll
	public static void afterAll(){
		driver.quit();
	}

	@BeforeEach
	public void beforeEach(){
		baseURL = "http://localhost:" + port;
		//had to create a user before login
		//wouldn't work other wise
		driver.get( baseURL + "/signup");
		signupPage.signup("lina","walaa", "lalash","123");
		signupPage.signup("mohamed","walaa", "meshmesh","123");
	}

	@Test
	public void signupTest() {
		driver.get(baseURL + "/signup");
		String msg = signupPage.signup("lina","walaa", "lolo","123");
		assertEquals("Signup Success",msg);

		driver.get(baseURL + "/signup");
		msg = signupPage.signup("lina","walaa", "lolo","123");
		assertEquals("Signup Error",msg);
	}

	@Test
	public void loginTest(){
		driver.get(baseURL + "/login");
		String msg = loginPage.login("lina", "12");
		assertEquals("Login Failed", msg);

		driver.get(baseURL + "/login");
		msg = loginPage.login("lalash", "123");
		assertEquals("Successful login", msg);
	}

	@Test
	public void sendMessageTest(){
		driver.get(baseURL + "/login");
		loginPage.login("lalash", "123");

		//the below line is not necessary because on successful
		// login we're redirected to the chat.html page
		//driver.get(baseURL + "/chat");

		ChatMessage lastMsg = chatPage.sendMessage("Shout","hi");
		assertEquals("lalash", lastMsg.getUsername());
		assertEquals("HI", lastMsg.getMessageBody());

		lastMsg = chatPage.sendMessage("Whisper","SAME");
		assertEquals("lalash", lastMsg.getUsername());
		assertEquals("same", lastMsg.getMessageBody());
	}

	@Test
	public void checkLastMessageTest(){
		driver.get(baseURL + "/login");
		loginPage.login("lalash", "123");

		//the below line is not necessary because on successful
		// login we're redirected to the chat.html page
		//driver.get(baseURL + "/chat");

		ChatMessage lastMsg = chatPage.sendMessage("Shout","love!");
		assertEquals("lalash", lastMsg.getUsername());
		assertEquals("LOVE!", lastMsg.getMessageBody());

		//checks if the other user can see the same last message submitted
		driver.get(baseURL + "/login");
		loginPage.login("meshmesh", "123");

		lastMsg = chatPage.getLastMessage();
		assertEquals("lalash", lastMsg.getUsername());
		assertEquals("LOVE!", lastMsg.getMessageBody());
	}

}
