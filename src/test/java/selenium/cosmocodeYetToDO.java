package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class cosmocodeYetToDO {

	public WebDriver driver;
	public String url = "https://cosmocode.io/automation-practice/";

	@FindBy(xpath = "//a[normalize-space()='Click here to reload this page']")
	WebElement link;
	@FindBy(id="firstname")
	WebElement fName;
	@FindBy(xpath="//input[@class='lastname']")
	WebElement lName;
	
	
	
	@BeforeClass
	public void browserSetup() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mathu\\eclipse-workspace\\NumpyNinja\\Numpy_Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver.get(url);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void testElements() {
		link.click();
		fName.sendKeys("Mathu");
		lName.sendKeys("Bala");
		
	}
}
