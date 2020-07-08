package testNgPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterDemo {
	WebDriver driver;

	@BeforeMethod
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");
	}
	
	@Test
	@Parameters({"userName", "password"})
	public void login(String userName, String password) {
	
		By USERNAME_lOCATOR = (By.id("username"));
		By PASSWORD_LOCATOR = By.id("password");

		driver.findElement(USERNAME_lOCATOR).sendKeys(userName);
		driver.findElement(PASSWORD_LOCATOR).sendKeys(password);

		driver.findElement(By.name("login")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
