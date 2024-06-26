package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sauceDemo {

	
	public WebDriver driver;
	public String url = "https://www.saucedemo.com/";
	public String prodName = "Sauce Labs Bike Light";
	
	@FindBy(id="user-name")
	WebElement userID;
	@FindBy(id="password")
	WebElement pwd;
	@FindBy(id="login-button")
	WebElement loginBtn;

	
	
	
	@BeforeTest
	public void browserSetup() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mathu\\eclipse-workspace\\NumpyNinja\\Numpy_Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
// 1. Launch the application https://www.saucedemo.com/
		driver.get(url);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}

	@Test
	public void sauceDemoLoginTest() throws Exception {
		userID.sendKeys("standard_user");
		pwd.sendKeys("secret_sauce");
		loginBtn.click();
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	
	@Test
	public void sauceDemoaddToCartTest() throws Exception {
		WebElement pName = driver.findElement(By.xpath("//*[contains(text(),'"+prodName+"')]/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div/following-sibling::button"));
		pName.click();
		
		
	}
	
	
	
	
	
	
	
	
	//@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
}
