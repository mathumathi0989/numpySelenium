package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tutorialsNinja {

	public WebDriver driver;
	public String url = "http://tutorialsninja.com/demo/index.php";
	public String productName = "Canon EOS 5D";
	public String product_Name;
	public String dynamicXPath = "//*[contains(text(),'" + productName + "')]";
	public String secondProdName = "iPhone";
	public String secondDynamicXPath = "//a[contains(text(),'" + secondProdName + "')]";
	public String addCartMessage;

	public String emailID = "mathu07621@gmail.com";

	@FindBy(xpath = "//*[@class='fa fa-caret-down']")
	WebElement currencyDD;
	@FindBy(xpath = "//button[@name='EUR']")
	WebElement euro;
	@FindBy(xpath = "//*[@class='fa fa-home']")
	WebElement homeBtn;
	@FindBy(id = "input-quantity")
	WebElement qty;
	@FindBy(xpath = "//*[@id='button-cart']")
	WebElement addToCart;
	@FindBy(xpath = "//div[@class='text-danger']")
	WebElement selectErrorMess;
	@FindBy(xpath = "//*[@id='cart-total']")
	WebElement cartTotal;
	@FindBy(xpath = "//*[contains(text(),'Success: You have added ')]")
	WebElement cartMessage;
	@FindBy(xpath = "//*[contains(text(),'View Cart')]")
	WebElement viewCart;
	@FindBy(xpath = "//*[@class='table-responsive']//tbody//*[@class='form-control']")
	WebElement updateQty;
	@FindBy(xpath = "//*[@class='col-sm-4 col-sm-offset-8']//*[contains(.,'Eco Tax')]/following-sibling::td")
	WebElement ecoTax;
	@FindBy(xpath = "//*[@class='col-sm-4 col-sm-offset-8']//*[contains(.,'VAT')]/following-sibling::td")
	WebElement vat;
	@FindBy(xpath = "//*[@class='buttons clearfix']/child::div[2]/a")
	WebElement checkoutBtn;
	@FindBy(xpath = "//*[contains(text(),'Products marked with ')]")
	WebElement checkoutError;
	@FindBy(xpath = "//*[@class='btn btn-danger']")
	WebElement remove;
	@FindBy(xpath = "//div[@id='content']/*[contains(text(),'Your shopping cart is empty!')]")
	WebElement removeMessage;
	@FindBy(xpath = "//li[@class='dropdown']/a[contains(text(),'Laptops & Notebooks')]")
	WebElement laptopLink;
	@FindBy(xpath = "//*[contains(text(),'Laptops')][@class='see-all']")
	WebElement laptopsAllLink;
	@FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
	WebElement HPLink;
	@FindBy(xpath = "//input[@id='input-quantity']")
	WebElement hpQty;
	@FindBy(linkText = "shopping cart")
	WebElement shoppingCart;
	@FindBy(xpath = "//a[@class='accordion-toggle']")
	WebElement couponCode;
	@FindBy(id = "input-coupon")
	WebElement couponValue;
	@FindBy(id = "button-coupon")
	WebElement applyCoupon;
	@FindBy(xpath = "//*[contains(text(),'Warning:')]")
	WebElement CodeError;
	@FindBy(xpath = "//a[normalize-space()='Use Gift Certificate']")
	WebElement giftCertificate;
	@FindBy(id = "input-voucher")
	WebElement giftCertificateValue;
	@FindBy(id = "button-voucher")
	WebElement applyGiftCertificate;
	@FindBy(xpath = "//a[@href='#collapse-voucher']")
	WebElement giftCertCollapse;
	@FindBy(xpath = "//a[@href='#collapse-coupon']")
	WebElement couponCollapse;

	@BeforeTest
	public void browserSetup() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mathu\\eclipse-workspace\\NumpyNinja\\Numpy_Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
// 1. Launch the application http://tutorialsninja.com/demo/index.php
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void tutorialsNinjaTest() throws Exception {
		PageFactory.initElements(driver, this);
		currencyDD.click();

// 2. Select the currency in the left top corner to Euro
		euro.click();
		product_Name = driver.findElement(By.xpath(dynamicXPath)).getText();
		System.out.println("Product choosen is " + product_Name);
		driver.findElement(
				By.xpath("//*[contains (text(),'Canon EOS 5D')]/following::div//span[contains (text(),'Add to Cart')]"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

// 3. Try to order a canon EOS 5 D camera and collect the error message occurred due to a bug in select option by clicking add to cart.
		addToCart.click();
		String selectErrorMessage = selectErrorMess.getText();
		System.out.println("Error message is " + selectErrorMessage);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		homeBtn.click();
		driver.findElement(By.xpath(secondDynamicXPath)).click();
		qty.clear();
		qty.sendKeys("2");

//4. Move to the home screen by clicking home icon, Click on iphone and go to details screen, change the quantity to two then add to cart.
		addToCart.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) cartMessage));
			addCartMessage = cartMessage.getText();
		} catch (Exception e) {
			System.out
					.println("Toast message not displayed within the timeout period. Continuing with the next steps.");
		}
//5. Print the success message in the console
		System.out.println(addCartMessage);

//6. Click on the cart icon (black color) in the right side top then click view cart
		cartTotal.click();
		viewCart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//7. Change the quantity of iphone to 3 and click update button
		updateQty.clear();
		updateQty.sendKeys("3");
		updateQty.sendKeys(Keys.ENTER);

//8. Print the Eco tax and VAT Amount in console and click Checkout button
		String ecoTax_Value = ecoTax.getText();
		System.out.println("Eco Tax is " + ecoTax_Value);
		String vat_Value = vat.getText();
		System.out.println("VAT Tax is " + vat_Value);
		checkoutBtn.click();

//9. Print the error message and remove the product from the cart
		String checkoutErrorMessage = checkoutError.getText();
		System.out.println(checkoutErrorMessage);
		remove.click();
		String removeMessageText = removeMessage.getText();
		System.out.println(removeMessageText);

//10. Move to the laptops screen and click on HP laptop, check the default quantity is 1 and click add to cart then verify success message
		laptopLink.click();
		laptopsAllLink.click();
		HPLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		String hpQtyValue = hpQty.getAttribute("value");
		System.out.println("HP Qty value is " + hpQtyValue);
		Assert.assertEquals(hpQtyValue, "1");
		addToCart.click();
		String addCartMessage1 = cartMessage.getText();
		System.out.println(addCartMessage1);

//11. Click on the shopping cart link in the top and apply ABCD123 as coupon code to check, print error message
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		shoppingCart.click();
		couponCode.click();
		couponValue.sendKeys("ABCD123");
		applyCoupon.click();
		couponCode.click();
		String couponErrorMessage = CodeError.getText();
		System.out.println("Coupon error message is " + couponErrorMessage);

//12. Enter AXDFGH123 as gift certificate and perform apply to check, print error message
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(giftCertificate));
		giftCertificate.click();
		giftCertificateValue.sendKeys("AXDFGH123");
		applyGiftCertificate.click();
		giftCertificate.click();
		String giftCertErrorMessage = CodeError.getText();
		System.out.println("Gift Certificate error message is " + giftCertErrorMessage);

//13. Clear both textbox values and proceed to checkout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		couponCollapse.click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.elementToBeClickable(couponValue));
		couponValue.clear();
		System.out.println("coupon cler done");
		wait2.until(ExpectedConditions.elementToBeClickable(giftCertCollapse));
		giftCertCollapse.click();
		wait2.until(ExpectedConditions.elementToBeClickable(giftCertificateValue));
		giftCertificateValue.clear();
		System.out.println("gift cler done");
		checkoutBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("checkout done");

//14. Select register account option and enter all account and billing details, click continue
		driver.findElement(By.id("button-account")).click();
		driver.findElement(By.id("input-payment-firstname")).sendKeys("mathu");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("mathi");
		driver.findElement(By.id("input-payment-email")).sendKeys(emailID);
		driver.findElement(By.id("input-payment-telephone")).sendKeys("1247626565");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("78 ave");
		driver.findElement(By.id("input-payment-city")).sendKeys("city");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("12354");
		driver.findElement(By.id("input-payment-password")).sendKeys("1234");
		driver.findElement(By.id("input-payment-confirm")).sendKeys("1234");
		Select s = new Select(driver.findElement(By.id("input-payment-country")));
		s.selectByValue("223");
		Select s1 = new Select(driver.findElement(By.id("input-payment-zone")));
		s1.selectByVisibleText("New Jersey");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.id("button-register")).click();

//15. Add comments, click continue and check the error message related to payment method
		driver.findElement(By.id("button-shipping-address")).click();
		driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("comments added for review");
		driver.findElement(By.id("button-shipping-method")).click();
		driver.findElement(By.id("button-payment-method")).click();
		String PaymentError = CodeError.getText();
		System.out.println("Payment error message is " + PaymentError);
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.id("button-payment-method")).click();
		// 16. Click on contact us hyperlink and submit a contact request and click
		// continue
		driver.findElement(By.id("button-confirm")).click();
		String orderMessage = driver.findElement(By.xpath("//h1[contains(text(),'Your order has been placed!')]"))
				.getText();
		System.out.println("Order Message is " + orderMessage);
		driver.findElement(By.linkText("Contact Us")).click();
		driver.findElement(By.id("input-enquiry")).sendKeys("Contact us message sent. Please check");
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		driver.findElement(By.linkText("Continue")).click();
		boolean homePage = driver.findElement(By.linkText("Qafox.com")).isDisplayed();
		Assert.assertEquals(true, homePage);

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
