package selenium;

import java.time.Duration;

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
	public String prodName = "Sauce Labs Fleece Jacket"; //change the product name 
	public String dynamicPName = "//*[contains(text(),'" + prodName
			+ "')]/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div/following-sibling::button";
	public String dynamicPprice = "//*[contains(text(),'" + prodName
			+ "')]/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div";

	@FindBy(id = "user-name")
	WebElement userID;
	@FindBy(id = "password")
	WebElement pwd;
	@FindBy(id = "login-button")
	WebElement loginBtn;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartLk;
	@FindBy(id = "checkout")
	WebElement chkBtn;
	@FindBy(xpath = "//*[@class='inventory_item_name']")
	WebElement checkout_ProdName;
	@FindBy(xpath = "//*[@class='inventory_item_price']")
	WebElement checkout_ProdPrice;
	@FindBy(id = "first-name")
	WebElement fName;
	@FindBy(id = "last-name")
	WebElement lName;
	@FindBy(id = "postal-code")
	WebElement zCode;
	@FindBy(id = "continue")
	WebElement continueBtn;
	@FindBy(xpath = "//div[@class='summary_total_label']")
	WebElement totalPrice;
	@FindBy(id = "finish")
	WebElement finishBtn;
	@FindBy(xpath = "//*[@class='complete-header']")
	WebElement thankMessage;
	@FindBy(id = "back-to-products")
	WebElement bkHome;

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
	public void sauceDemoLoginTest() throws Exception {
		userID.sendKeys("standard_user");
		pwd.sendKeys("secret_sauce");
		loginBtn.click();
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

	@Test
	public void sauceDemoaddToCartTest() throws Exception {

		WebElement pName = driver.findElement(By.xpath(dynamicPName));
		System.out.println("Product name is "+prodName);
		String prodPrice = driver.findElement(By.xpath(dynamicPprice)).getText();
		System.out.println("Product price is "+prodPrice);
		pName.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cartLk.click();
		String cPage_Pname = checkout_ProdName.getText();
		Assert.assertEquals(cPage_Pname, prodName);
		String cPage_PPrice = checkout_ProdPrice.getText();
		Assert.assertEquals(cPage_PPrice, prodPrice);
		chkBtn.click();
		fName.sendKeys("Mathu");
		lName.sendKeys("Bala");
		zCode.sendKeys("1234");
		continueBtn.click();
		String oPage_Pname = checkout_ProdName.getText();
		Assert.assertEquals(oPage_Pname, prodName);
		String oPage_PPrice = checkout_ProdPrice.getText();
		Assert.assertEquals(oPage_PPrice, prodPrice);
		System.out.println("Total Price is :" + totalPrice.getText());
		finishBtn.click();
		String orderMessage = thankMessage.getText();
		System.out.println(driver.findElement(By.xpath("//div[@class='complete-text']")).getText());
		Assert.assertEquals(orderMessage, "Thank you for your order!");
		bkHome.click();
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
