package assign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment2 {
	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");
	}

	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//form[@class='login']//descendant::input[@id='username']"))
				.sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//div[@class='form-group']//child::input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//div[@class='form-group']//following::button[@type='submit']")).click();

		driver.findElement(By.linkText("Customers")).click();
		driver.findElement(By.linkText("Add Customer")).click();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement Name = driver.findElement(By.xpath("//input[@id='account']"));
		wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name.sendKeys("Najira Jinna");

		WebElement Company_dropDown = driver.findElement(By.id("cid"));

		Select select = new Select(Company_dropDown);
		select.selectByVisibleText("Techfios");

		driver.findElement(By.id("email")).sendKeys("najirajinna@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("5678452145");
		driver.findElement(By.id("address")).sendKeys("567 Parklama");
		driver.findElement(By.id("city")).sendKeys("Dallas");
		driver.findElement(By.id("state")).sendKeys("Texas");
		driver.findElement(By.id("zip")).sendKeys("75252");

		Thread.sleep(2000);
		WebElement Group = driver.findElement(By.id("group"));
		Select select1 = new Select(Group);
		select1.selectByVisibleText("Mid Spring 2020");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("List Customers")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("foo_filter")).sendKeys("najirajinna@gmail.com");
		Thread.sleep(4000);

		WebElement x = driver.findElement(By.xpath("//td[contains(text(),'najirajinna@gmail.com')]"));
		Assert.assertTrue(x.isDisplayed(), "Page Not Found");

//		List<WebElement> rowElements = driver.findElements(By.xpath("//table[@data-filter='#foo_filter']//child::tbody//child::tr"));
//		System.out.println(rowElements.size());
//		
//		for(int i = 0; i < rowElements.size(); i++) {
//			System.out.println(i);
//			int rowNum = i + 1;
//			WebElement row = driver.findElement(By.xpath("//table[@data-filter='#foo_filter']//child::tbody//child::tr[" + rowNum + "]"));
//			String dispStyle = row.getCssValue("display");
//			System.out.println(dispStyle);
//			
//			if(dispStyle.equalsIgnoreCase("table-row")) {
//				
//				WebElement nameElement = driver.findElement(By.xpath("//table[@data-filter='#foo_filter']//child::tbody//child::tr//child::td[3]//child::a"));
//				String displayName = nameElement.getText();
//				System.out.println(displayName);
//				
//				Boolean nameCheck = displayName.equalsIgnoreCase("Najira Jinna");
//				Assert.assertTrue("Incorrect Name", nameCheck);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
