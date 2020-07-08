package testNgPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation2 {
	WebDriver driver;
	String browser = null;

	@BeforeTest
	public void configProp() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("Config\\confiq.properties");
		prop.load(fis);

		browser = prop.getProperty("Browser");
	}

	@BeforeMethod
	public void launchBrowser() {

		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("fireFox")) {
			System.setProperty("webdriver.gecko.driver", "driver\\geclodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");
	}

	@Test(priority = 1)
	public void login() {

		By USERNAME_lOCATOR = (By.id("username"));
		By PASSWORD_LOCATOR = By.id("password");

		String userName = "demo@techfios.com";
		String passWord = "abc123";

		driver.findElement(USERNAME_lOCATOR).sendKeys(userName);
		driver.findElement(PASSWORD_LOCATOR).sendKeys(passWord);

		driver.findElement(By.name("login")).click();

		By DASHBOARD_BUTTON_LOCATOR = By.xpath("//h2[contains(text(), 'Dashboard')]");
		WebElement Dashboar_Text = driver.findElement(DASHBOARD_BUTTON_LOCATOR);
		String Dashbard_Text2 = Dashboar_Text.getText();
		Assert.assertEquals("Dashboard", Dashbard_Text2, "Not Same");
	}

	@Test(priority = 2)
	public void addCustomer() throws InterruptedException {

		By USER_NAME_FIELD = By.id("username");
		By PASSWORD_FIELD = By.id("password");
		By SIGNIN_BUTTON = By.name("login");

		By DASHBOARD_BUTTON = By.xpath("//span[contains(text(), 'Dashboard')]");

		By CUSTOMERS_BUTTON = By.xpath("//span[contains(text(), 'Customers')]");
		By ADD_CUSTOMER_BUTTON = By.xpath("//a[contains(text(), 'Add Customer')]");

		By ADD_CONTACT_LOCATOR = By.xpath("//h5[contains(text(),'Add Contact')]");

		By FULL_NAME_FIELD = By.xpath("//input[@id='account']");
		By COMPANY_NAME_FIELD = By.xpath("//input[@id='company']");
		By EMAIL_FIELD = By.xpath("//input[@id='email']");
		By PHONE_FIELD = By.xpath("//input[@id='phone']");
		By ADDRESS_FIELD = By.xpath("//input[@id='address']");
		By CITY_FIELD = By.xpath("//input[@id='city']");
		By STATE_REGION_FIELD = By.xpath("//input[@id='state']");
		By ZIP_FIELD = By.xpath("//input[@id='zip']");

		By SUBMIT_BUTTON = By.id("submit");

		By List = By.linkText("List Customers");

		String userName = "demo@techfios.com";
		String passWord = "abc123";

		String fullName = "Sara";
		//String companyName = "Sysco";
		String email = "Sanam@yahoo.co.in";
		String phone = "2367891035";
		String address = " 12 lake blvd";
		String city = "Frisco";
		String State = " Texas";
		String zip = "78021";

		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys(passWord);
		driver.findElement(SIGNIN_BUTTON).click();

		driver.findElement(CUSTOMERS_BUTTON).click();
		driver.findElement(ADD_CUSTOMER_BUTTON).click();
		waitForElement(driver, 60, FULL_NAME_FIELD);
		driver.findElement(FULL_NAME_FIELD).sendKeys(fullName);
		// driver.findElement(COMPANY_NAME_FIELD).sendKeys(companyName);
		driver.findElement(EMAIL_FIELD).sendKeys(email);
		driver.findElement(PHONE_FIELD).sendKeys(phone);
		driver.findElement(ADDRESS_FIELD).sendKeys(address);
		driver.findElement(CITY_FIELD).sendKeys(city);
		driver.findElement(STATE_REGION_FIELD).sendKeys(State);
		driver.findElement(ZIP_FIELD).sendKeys(zip);

		driver.findElement(SUBMIT_BUTTON).click();
Thread.sleep(5000);
		waitForElement(driver, 60, List);
		
		driver.findElement(List).click();
		Thread.sleep(5000);
		driver.findElement(By.id("foo_filter")).sendKeys("Sanam@yahoo.co.in");

		WebElement x = driver.findElement(By.xpath("//td[contains(text(),'Sanam@yahoo.co.in')]"));
		Assert.assertTrue(x.isDisplayed(), "Page Not Found");
	}
	@AfterMethod
	public void tearDown(){
		driver.close();
		
	}

	public void waitForElement(WebDriver driver, int secs, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
