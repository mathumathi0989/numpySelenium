package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class bstackdemo {
	public WebDriver driver ;
	String url = "https://bstackdemo.com/";
	String title = "iPhone XS"; //One Plus 8 Pro, One Plus 6T, Galaxy S10
	 String userName = "demouser";
	 String password = "testingisfun99";
	String firstName = "Mathu";
	String lastName = "Bala";
	String addressValue = "avenue E";
	String stateValue = "nj";
	String zipCodeValue = "1234";
	
	@FindBy(xpath="//*[@class='filters']/div[1]//span") WebElement vendorSelection;
	@FindBy(xpath="//*[@class='shelf-item__details']/p") WebElement checkoutTitle;
	@FindBy(xpath= "//p[@class='sub-price__val']") WebElement checkoutPrice;
	@FindBy(xpath="//*[@class='buy-btn']") WebElement checkoutBtn;
	@FindBy(xpath="//div[text()='Select Username']") WebElement userNameTextSelection;
	@FindBy(xpath="(//div[text()='Select Username']//following::input)[1]") WebElement userNameTextEdit ;
	@FindBy(xpath="//*[@id='password']") WebElement passwordTextSelection;
	@FindBy(xpath="//*[@id='password']//following::input") WebElement passwordTextEdit;
	@FindBy(xpath="//*[@id='firstNameInput']") WebElement fName;
	@FindBy(xpath="//*[@id='lastNameInput']") WebElement lName;
	@FindBy(xpath="//*[@id='addressLine1Input']") WebElement address;
	@FindBy(xpath="//*[@id='provinceInput']") WebElement state;
	@FindBy(xpath="//*[@id='postCodeInput']") WebElement zipCode;
	@FindBy(xpath="//*[@class='product']/div/h5") WebElement ShippingName ;
	@FindBy(xpath="//*[@class='cart-priceItem-value']/span") WebElement ShippingPrice;
	@FindBy(xpath= "//*[@id='checkout-shipping-continue']") WebElement Checkout ;
	@FindBy(xpath="//*[@class='form-legend-container']/legend") WebElement OrderMessage;
	@FindBy(xpath="//*[@class='checkout-form']/div[2]/strong") WebElement orderNo;
	@FindBy(xpath="//*[@class='product']/div/h5") WebElement OrderPageName;
	@FindBy(xpath="//*[@class='cart-priceItem-value']") WebElement OrderPagePrice;

	By prodName = By.xpath("//p[normalize-space()='"+title+"']");
	By prodPrice = By.xpath("//*[normalize-space()='"+title+"']/following-sibling::div/div[1]");
	By addToCart = By.xpath("//*[normalize-space()='"+title+"']/following::div[@class='shelf-item__buy-btn'][1]");

	
	
	
	
	@BeforeTest
	public void browserSetup() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mathu\\eclipse-workspace\\NumpyNinja\\Numpy_Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver.get(url);
		
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void bstackDemoTest() throws Exception {
		PageFactory.initElements(driver, this);
				vendorSelection.click();
				String prod_Name = driver.findElement(prodName).getText();
				System.out.println("Product Name is " +prod_Name);
				String prod_price = driver.findElement(prodPrice).getText();
				System.out.println("Product Price is " +prod_price);
				driver.findElement(addToCart).click();
				Thread.sleep(200);
				
				//check out Page	
				String checkOut_Title = checkoutTitle.getText();
				System.out.println("checkout Page - Product Name is " +checkOut_Title);
				String checkOut_Price = checkoutPrice.getText();
				System.out.println("checkout Page - Product Price is " +checkOut_Price);
				checkoutBtn.click();
				Thread.sleep(700);
				
				//Login Page
				userNameTextSelection.click();
				WebElement uName =	userNameTextEdit;
				uName.sendKeys(userName);
				Thread.sleep(700);
				uName.sendKeys(Keys.ENTER);
				uName.sendKeys(Keys.TAB);
				passwordTextSelection.click();;
				WebElement uPwd = passwordTextEdit;
				uPwd.sendKeys(password);
				uPwd.sendKeys(Keys.TAB);
				uPwd.sendKeys(Keys.ENTER);
				Thread.sleep(500);

				//Shipping Page
				fName.sendKeys(firstName);
				lName.sendKeys(lastName);
				address.sendKeys(addressValue);
				state.sendKeys(stateValue);
				zipCode.sendKeys(zipCodeValue);
				String Shipping_Name = ShippingName.getText();
				System.out.println("Shipping Page - Product Name is " +Shipping_Name);
				String Shipping_Price = ShippingPrice.getText();
				System.out.println("Shipping Page - Product Price is " +Shipping_Price);
				Checkout.click();
				Thread.sleep(700);

				//Order Page
				String orderText = OrderMessage.getText();
				System.out.println("Confirmation message is " + "'" +orderText +"'");
				String orderId = orderNo.getText();
				System.out.println("Order number is "+orderId);
				String orderTitle = OrderPageName.getText();
				System.out.println("Order Page - Product Name is " +orderTitle);
				String orderPrice = OrderPagePrice.getText();
				System.out.println("Order Page - Product Price is "+orderPrice);

	}


	@AfterTest
	public void TearDown() {
		driver.close();
	}

	
}
