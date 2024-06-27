package selenium;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class juiceShop {

	public WebDriver driver;
	public String url = "https://juice-shop.herokuapp.com/#/";

	@FindBy(xpath = "//*[contains(text(),'Dismiss')]")
	WebElement dismissAlert;
	@FindBy(xpath = "//*[contains(text(),' Account ')]")
	WebElement account;
	@FindBy(id = "navbarLoginButton")
	WebElement login;
	@FindBy(id = "email")
	WebElement email;
	@FindBy(id = "password")
	WebElement pwd;
	@FindBy(id = "loginButton")
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

	@Test(priority = 1)
	public void juiceshopLoginTest() throws Exception {
		dismissAlert.click();
		account.click();
		login.click();
		email.sendKeys("qwe@gmail.com");
		pwd.sendKeys("123456");
		loginBtn.click();
	}

	@Test(priority = 2)
	public void addOrderTest() throws Exception {
		
		// Please add one or two items to basket (from each page) – scroll, navigate and select product
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Add to Basket']")));
		driver.findElement(By.xpath(
				"//*[@class='mat-grid-list']//following::div[contains(text(),' Carrot Juice (1000ml) ')]/ancestor::div[@class='mat-tooltip-trigger product']/following-sibling::div/button"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath("//button[@aria-label='Next page']/span[@class='mat-button-wrapper']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath(
				"//*[@class='mat-grid-list']//following::div[contains(text(),' OWASP Juice Shop Logo (3D-printed) ')]/ancestor::div[@class='mat-tooltip-trigger product']/following-sibling::div/button"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//*[contains(text(),' Your Basket')]")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='mat-table cdk-table']")));
		for (int i = 1; i <= 2; i++) {
			WebElement incrementButtonRow1 = wait
					.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(
							By.xpath("//*[@class='mat-table cdk-table']/mat-row[1]/child::mat-cell[3]/button[2]"))));
			incrementButtonRow1.click();
			incrementButtonRow1 = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@class='mat-table cdk-table']/mat-row[1]/child::mat-cell[3]/button[2]"))));
			incrementButtonRow1.click();

			WebElement incrementButtonRow2 = wait
					.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(
							By.xpath("//*[@class='mat-table cdk-table']/mat-row[2]/child::mat-cell[3]/button[2]"))));
			incrementButtonRow2.click();
			incrementButtonRow2 = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@class='mat-table cdk-table']/mat-row[2]/child::mat-cell[3]/button[2]"))));
			incrementButtonRow2.click();
			// Wait to ensure the UI is updated before the next iteration
			wait.until(ExpectedConditions.stalenessOf(incrementButtonRow1));
			wait.until(ExpectedConditions.stalenessOf(incrementButtonRow2));
		}

		// Press checkout and add a new address (for all inputs generate random values using code and don’t hard code)
		driver.findElement(By.id("checkoutButton")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Add New Address')]")).click();
		String genCountry = RandomStringUtils.randomAlphabetic(5);
		String genName = RandomStringUtils.randomAlphabetic(8);
		String genMobile = RandomStringUtils.randomNumeric(10);
		String genZip = RandomStringUtils.randomNumeric(5);
		String genAddress = RandomStringUtils.randomAlphanumeric(15);
		String genCity = RandomStringUtils.randomAlphabetic(6);
		String genState = RandomStringUtils.randomAlphabetic(3);
		String gencard = RandomStringUtils.randomNumeric(16);
		driver.findElement(
				By.xpath("//*[contains(text(),'Country')]/preceding::input[@placeholder='Please provide a country.']"))
				.sendKeys(genCountry);
		driver.findElement(
				By.xpath("//*[contains(text(),'Name')]/preceding::input[@placeholder='Please provide a name.']"))
				.sendKeys(genName);
		driver.findElement(By.xpath(
				"//*[contains(text(),'Mobile Number')]/preceding::input[@placeholder='Please provide a mobile number.']"))
				.sendKeys(genMobile);
		driver.findElement(By
				.xpath("//*[contains(text(),'ZIP Code')]/preceding::input[@placeholder='Please provide a ZIP code.']"))
				.sendKeys(genZip);
		driver.findElement(By.xpath(
				"//*[contains(text(),'Address')]/preceding::textarea[@placeholder='Please provide an address.']"))
				.sendKeys(genAddress);
		driver.findElement(
				By.xpath("//*[contains(text(),'City')]/preceding::input[@placeholder='Please provide a city.']"))
				.sendKeys(genCity);
		driver.findElement(
				By.xpath("//*[contains(text(),'State')]/preceding::input[@placeholder='Please provide a state.']"))
				.sendKeys(genState);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.id("submitButton")).click();

		// Select the address and any delivery speed
		driver.findElement(By.xpath("//span[@class='mat-radio-inner-circle']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Continue')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("//mat-radio-button[@id='mat-radio-44']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Continue')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		// Add a new card, try to add a fake coupon (10 digits) and verify error message. Select card, review and place the order.
		driver.findElement(By.xpath("//*[contains(text(),' Add new card ')]")).click();
		waitForPageLoad(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("//*[contains(text(),'Name')]/ancestor::span/preceding-sibling::input"))
				.sendKeys(genName);
		driver.findElement(By.xpath("//*[contains(text(),'Card Number')]/ancestor::span/preceding-sibling::input"))
				.sendKeys(gencard);
		Select s = new Select(driver.findElement(
				By.xpath("//*[contains(text(),'Expiry Month')]/ancestor::span/preceding-sibling::select")));
		s.selectByVisibleText("9");
		Select s1 = new Select(driver
				.findElement(By.xpath("//*[contains(text(),'Expiry Year')]/ancestor::span/preceding-sibling::select")));
		s1.selectByVisibleText("2090");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//*[contains(text(),' Add a coupon ')][1]")).click();
		driver.findElement(By.id("coupon")).sendKeys(genMobile);
		driver.findElement(By.xpath("//*[contains(text(),' redeem ')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Invalid coupon. ')]")).getText(),
				"Invalid coupon.");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebElement cardRadio = driver.findElement(By.xpath("//span[@class='mat-radio-outer-circle']"));
		scrollIntoViewAndClick(driver, cardRadio);
		driver.findElement(By.xpath("//*[contains(text(),'Continue')]")).click();
		driver.findElement(By.id("checkoutButton")).click();
		String thank = driver.findElement(By.xpath("//*[contains(text(),'Thank you')]")).getText();
		Assert.assertEquals(thank, "Thank you for your purchase!");
		String orderMessage = driver.findElement(By.xpath("//*[contains(text(),'Your order has')]")).getText();
		System.out.println("Order Message is ' " + orderMessage + " '");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement totalPriceAOEle = wait2.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='price-align']/tr[4]/td")));
		String totalPriceAO = driver.findElement(By.xpath("//table[@class='price-align']/tr[4]/td")).getText();
		System.out.println("Total price is " + totalPriceAO);

		// Verify in Account, order history -> print order, track order
		driver.findElement(By.xpath("//span[normalize-space()='Account']")).click();
		driver.findElement(By.xpath(
				"//button[@aria-label='Show Orders and Payment Menu']//span[contains(text(),'Orders & Payment')]"))
				.click();
		driver.findElement(By.xpath("//span[normalize-space()='Order History']")).click();
		WebElement totalPriceOHEle = wait2.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='heading']/div/div[2]/div[2]")));
		String totalPriceOH = driver.findElement(By.xpath("//div[@class='heading']/div/div[2]/div[2]")).getText();
		System.out.println("Total price is " + totalPriceOH);
		Assert.assertEquals(totalPriceAO, totalPriceOH);
		driver.findElement(By.xpath("//button[@aria-label='Track Your Order']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//div[@class='heading']/div/div[6]")).click();
		
		// Then logout from the application
		try {
			driver.findElement(By.xpath("//span[normalize-space()='Account']")).click();
			driver.findElement(By.xpath("//button[@id='navbarLogoutButton']//span[contains(text(),'Logout')]")).click();
		} catch (ElementClickInterceptedException e) {
			WebElement logoutButton = driver
					.findElement(By.xpath("//button[@id='navbarLogoutButton']//span[contains(text(),'Logout')]"));
			scrollIntoViewAndClick(driver, logoutButton);
		}
		String title = driver.getTitle();
		Assert.assertEquals(title, "OWASP Juice Shop");

	}

	public static void waitForPageLoad(WebDriver driver) {
		new WebDriverWait(driver, Duration.ofSeconds(60)).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
	}

	public static void scrollIntoViewAndClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("arguments[0].click();", element);
	}

	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
