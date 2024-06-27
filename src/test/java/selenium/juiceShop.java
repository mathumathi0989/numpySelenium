package selenium;

import java.time.Duration;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

	@Test(priority=1)
	public void juiceshopLoginTest() throws Exception {
		dismissAlert.click();
		account.click();
		login.click();
		email.sendKeys("mnb@gmail.com");
		pwd.sendKeys("123456");
		loginBtn.click();
		
	}

	
	@Test(priority=2)
	public void checkProdTest() throws Exception {
		
		//Please add one or two items to basket (from each page) – scroll, navigate and select product 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Add to Basket']")));
	driver.findElement(By.xpath("//*[@class='mat-grid-list']//following::div[contains(text(),' Carrot Juice (1000ml) ')]/ancestor::div[@class='mat-tooltip-trigger product']/following-sibling::div/button")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	/*
	WebElement toast = driver.findElement(By.xpath("//span[@class='mat-simple-snack-bar-content']"));
	
	System.out.println(toast.getText());
	*/
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)", "");
	driver.findElement(By.xpath("//button[@aria-label='Next page']/span[@class='mat-button-wrapper']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.xpath("//*[@class='mat-grid-list']//following::div[contains(text(),' OWASP Juice Shop Logo (3D-printed) ')]/ancestor::div[@class='mat-tooltip-trigger product']/following-sibling::div/button")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	/*
	WebElement toast1 = driver.findElement(By.xpath("//span[@class='mat-simple-snack-bar-content']"));

	System.out.println(toast1.getText());
	*/
	
	driver.findElement(By.xpath("//*[contains(text(),' Your Basket')]")).click();
	 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
     wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='mat-table cdk-table']")));
     
	for (int i = 1; i <= 2; i++) {
        // Click the increment button for the first row
    WebElement incrementButtonRow1 = driver.findElement(By.xpath("//*[@class='mat-table cdk-table']/mat-row[1]/child::mat-cell[3]/button[2]"));
     wait.until(ExpectedConditions.elementToBeClickable(incrementButtonRow1));
        incrementButtonRow1.click();
   wait.until(ExpectedConditions.elementToBeClickable(incrementButtonRow1));
        incrementButtonRow1.click();
        System.out.println("Row 1 clicked " + i + " times");

        // Click the increment button for the second row
        WebElement incrementButtonRow2 = driver.findElement(By.xpath("//*[@class='mat-table cdk-table']/mat-row[2]/child::mat-cell[3]/button[2]"));
     wait.until(ExpectedConditions.elementToBeClickable(incrementButtonRow2));
        incrementButtonRow2.click();
     wait.until(ExpectedConditions.elementToBeClickable(incrementButtonRow2));
        incrementButtonRow2.click();
        System.out.println("Row 2 clicked " + i + " times");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
	
	//Press checkout and add a new address (for all inputs generate random values using code and don’t hard code) 
	driver.findElement(By.id("checkoutButton")).click();
	driver.findElement(By.xpath("//*[contains(text(),'Add New Address')]")).click();
	
	String genCountry = RandomStringUtils.randomAlphabetic(5);
	String genName = RandomStringUtils.randomAlphabetic(8);
	String genMobile= RandomStringUtils.randomNumeric(10);
	String genZip= RandomStringUtils.randomNumeric(5);
	String genAddress= RandomStringUtils.randomAlphanumeric(15);
	String genCity = RandomStringUtils.randomAlphabetic(6);
	String genState = RandomStringUtils.randomAlphabetic(3);
	
	driver.findElement(By.xpath("//*[contains(text(),'Country')]/preceding::input[@placeholder='Please provide a country.']")).sendKeys(genCountry);
	driver.findElement(By.xpath("//*[contains(text(),'Name')]/preceding::input[@placeholder='Please provide a name.']")).sendKeys(genName);
	driver.findElement(By.xpath("//*[contains(text(),'Mobile Number')]/preceding::input[@placeholder='Please provide a mobile number.']")).sendKeys(genMobile);
	driver.findElement(By.xpath("//*[contains(text(),'ZIP Code')]/preceding::input[@placeholder='Please provide a ZIP code.']")).sendKeys(genZip);
	driver.findElement(By.xpath("//*[contains(text(),'Address')]/preceding::textarea[@placeholder='Please provide an address.']")).sendKeys(genAddress);
	driver.findElement(By.xpath("//*[contains(text(),'City')]/preceding::input[@placeholder='Please provide a city.']")).sendKeys(genCity);
	driver.findElement(By.xpath("//*[contains(text(),'State')]/preceding::input[@placeholder='Please provide a state.']")).sendKeys(genState);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	driver.findElement(By.id("submitButton")).click();
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
try {
			 String pnamexPath = "//*[@class='mat-grid-list']//following::div[contains(text(),'" +prodName +"')]";
			 JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)", "");
		if(driver.findElement(By.xpath(pnamexPath)).isDisplayed()) {
			
			System.out.println("prod name displayed");
			driver.findElement(By.xpath("//*[@class='mat-grid-list']//following::div[contains(text(),'" +prodName+"')]/ancestor::div[@class='mat-tooltip-trigger product']/following-sibling::div/button")).click();
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
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Add to Basket']")));
			
			driver.findElement(By.xpath("//button[@aria-label='Next page']/span[@class='mat-button-wrapper']")).click();
		
			checkProdTest();
	}
	 */
}
