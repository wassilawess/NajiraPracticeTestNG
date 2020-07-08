package testNgPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SimpleAnnotation1 {
	WebDriver driver;

	@BeforeTest
	public void browser1() {
		System.out.println("BeforeTest");
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@BeforeMethod

	public void lauch() {
		System.out.println("Before Method");
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");

	}

	@Test(priority = 1)

	public void login() {
		System.out.println("login priority 1");
		WebElement USERNAMEELEMENT = driver.findElement(By.id("username"));
		USERNAMEELEMENT.sendKeys("demo.techfios.com");

		By PASSWORDLOCATOR = (By.id("password"));
		driver.findElement(PASSWORDLOCATOR).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

	}

	@Test(priority = 2, enabled = false)
	public void login1() {
		System.out.println("login1 false ");

		By USERNAME_lOCATOR = (By.id("username"));
		driver.findElement(USERNAME_lOCATOR).sendKeys("demo@techfios.com");

		By PASSWORD_LOCATOR = By.id("password");
		driver.findElement(PASSWORD_LOCATOR).sendKeys("abc123");

		driver.findElement(By.name("login")).click();

	}

	@Test(priority = 3)
	public void incorrectUserName() {
		System.out.println("incorrectUserName Priority 3");

		WebElement USERNAME_ELEMENT = driver.findElement(By.id("username"));
		USERNAME_ELEMENT.sendKeys("demon@techfios.com");

		WebElement PASSWORD_ELEMENT = driver.findElement(By.id("password"));
		PASSWORD_ELEMENT.sendKeys("abc123");

		driver.findElement(By.name("login")).click();

	}

	@Test
	public void incorrectPassword() {
		System.out.println("incorrectPassword_Test");

		WebElement USERNAME_ELEMENT = driver.findElement(By.id("username"));
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");

		WebElement PASSWORD_ELEMENT = driver.findElement(By.id("password"));
		PASSWORD_ELEMENT.sendKeys("abc12345");

		driver.findElement(By.name("login")).click();
	}

	@AfterMethod
	public void Validation() {
		System.out.println("AfterMethod");
		driver.manage().deleteAllCookies();
		String DashBoard = "http://www.techfios.com/ibilling/?ng=dashboard/";
		String x = driver.getCurrentUrl();
		
		// Using Soft Assertion
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(DashBoard, x);

	}

	@AfterTest
	public void teardown() {
		System.out.println("AfterTest");
		driver.close();
	}
}
