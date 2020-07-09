package testNgPractice;


	import java.awt.event.InputEvent;
	import java.util.List;
	import java.util.Random;
	import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	public class TestMergeClassAddCostomer {
		
		WebDriver driver;

		@Before

		public void lunchbrowser() throws InterruptedException {

			// setting up the property
			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

			// creating web driver instance
			driver = new ChromeDriver();

			// maximizing browser
			driver.manage().window().maximize();

			// get to the site
			driver.get("http://techfios.com/ibilling/?ng=admin/");

			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		}
		
		@Test
		public void lunch() throws InterruptedException {
			
			// indentification
			
			driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
			driver.findElement(By.id("password")).sendKeys("abc123");
			
			//use the keyboard instead of using the submit  button
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).build().perform();
			
			
			//go to side bar : customer
			
			driver.findElement(By.xpath("//ul[@id='side-menu']/li[3]/a/span[1]")).click();
			
			
			//add the customer
			driver.findElement(By.xpath("//*[@id='side-menu']/li[3]/ul/li[1]/a")).click();
			
		  Thread.sleep(2000);
			
		  
		 
			// for the full name 
			WebElement fullName = driver.findElement(By.xpath("//*[@id='account']"));
			
			fullName.sendKeys("test"+ new Random().nextInt(999));
			
			System.out.println(fullName);
			
			Thread.sleep(2000);
			
			

			
			
			// mth 2 for entering the company
			driver.findElement(By.id("cid")).sendKeys("Techfios");

			
			//for the email
			Thread.sleep(2000);	
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys("mail"+ new Random().nextInt(999)+ "@mail.com");
			
			//for the phone number
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='phone']")).sendKeys("1234"+new Random().nextInt(9999));

			//for the address
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='address']")).sendKeys("address");

			//for the city
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='city']")).sendKeys("city");

			//for the state 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='state']")).sendKeys("state");

			//for the zip code
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='zip']")).sendKeys("23135");

			
			//country
			Thread.sleep(2000);	
			WebElement COUNTRY_DROPDOWN_LOCATOR = driver.findElement(By.xpath("//select[@id='country']"));
			Select sel = new Select(COUNTRY_DROPDOWN_LOCATOR);
			sel.selectByVisibleText("United States");
			
		
			Thread.sleep(2000);
			
			WebElement tag_txt = driver.findElement(By.xpath("//*[@id=\"rform\"]/div[1]/div[1]/div[10]/div/span/span[1]/span/ul/li/input"));

			tag_txt.sendKeys("usa");

			Actions tag_act = new Actions(driver);

			tag_act.sendKeys(Keys.ENTER).build().perform();
							

			
			//for curency
	    	Thread.sleep(1000);
			driver.findElement(By.name("currency")).sendKeys("USD");
		
			//entring the group
			Thread.sleep(1000);
			driver.findElement(By.name("group")).sendKeys("Mid Spring 2020");
			
			//entring password
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("mypassword");
		
			//confirm password
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='cpassword']")).sendKeys("mypassword");

			//for welcome email
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"rform\"]/div[1]/div[2]/div[5]/div/div/div/label[2]")).click();
			
			Thread.sleep(1000);

			//submit
			driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
			
			Thread.sleep(3000);
		
		}
		
		@After
		public void tearDown() {
			
			driver.close();
			driver.quit();
		}

	}


