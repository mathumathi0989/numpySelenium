package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class juiceShop {

	public WebDriver driver;
	public String url = "https://juice-shop.herokuapp.com/#/";
	
	@FindBy(xpath = "//*[contains(text(),'Dismiss')]")
	WebElement dismissAlert;
	@FindBy (xpath = "//*[contains(text(),' Account ')]")
	WebElement account;
	@FindBy (id="navbarLoginButton")
	WebElement login;
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="password")
	WebElement pwd;
	@FindBy (id="loginButton")
	WebElement loginBtn;
	
	public String prod_name = " OWASP Juice Shop Sticker Page ";
	
	
	@FindBy(xpath = "//button[@aria-label='Next page']")
	WebElement next;
	
	
	
	
	
	@BeforeTest
	public void browserSetup() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mathu\\eclipse-workspace\\NumpyNinja\\Numpy_Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver.get(url);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}

	@Test
	public void juiceshopLoginTest() throws Exception {
		dismissAlert.click();
		account.click();
		login.click();
		email.sendKeys("mathu@gmail.com");
		pwd.sendKeys("123456");
		loginBtn.click();
		
	}

	
	@Test
	public void checkProdTest() throws Exception {
		try {
			 String pnamexPath = "//*[@class='mat-grid-list']//following::div[contains(text(),'" +prod_name +"')]";
			 JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)", "");
		if(driver.findElement(By.xpath(pnamexPath)).isDisplayed()) {
			
			System.out.println("prod name displayed");
		}
		}
		catch(Exception e) {
		
			try {
			    // Attempt to close the overlay if it's present
			    WebElement overlay = driver.findElement(By.className("cdk-overlay-backdrop"));
			    if (overlay.isDisplayed()) {
			        overlay.click();  // Or perform any action that closes the overlay
			    }
			} catch (NoSuchElementException e1) {
			    // Overlay not found, continue with the next step
			}
			
			driver.findElement(By.xpath("//button[@aria-label='Next page']/span[@class='mat-button-wrapper']")).click();
			
			checkProdTest();
			
		
		}
	
	}
	
	
	
	
	
	
	
}
