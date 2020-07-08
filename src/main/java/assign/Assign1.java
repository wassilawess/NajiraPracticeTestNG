package assign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assign1 {
	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://www.techfios.com/ibilling/?ng=admin/");

	}

	@Test
	public void login() throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("abc123");
		Thread.sleep(2000);

		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Transactions")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("/html/body/section/div/nav/div/ul/li[5]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.className("select2-selection__arrow")).click();

		Select accountDropdown = new Select(driver.findElement(By.id("account")));
		Thread.sleep(2000);
		accountDropdown.selectByVisibleText("Green62");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input#description")).sendKeys("Paid for Najira");
		
		
		Thread.sleep(2000);
		driver.findElement(By.id("amount")).sendKeys("1000");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();

	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}
}
