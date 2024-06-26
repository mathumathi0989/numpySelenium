package selenium;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class browserCapabilities {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//EdgeOptions
		//firefoxOptions
		//SafariOptions
				
		ChromeOptions chromeOptions = new ChromeOptions();
		
		// This will make Selenium WebDriver to wait for the entire page gets loaded while launching website.
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//This capability checks whether an expired (or) invalid TLS Certificate is used while navigating during a session
		chromeOptions.setAcceptInsecureCerts(true);
		
		//Specifies when to interrupt an executing script in a current browsing context. The default timeout 30,000 ms
		chromeOptions.setScriptTimeout(Duration.ofSeconds(30));
		
		//Specifies the time interval in which web page needs to be loaded in a current browsing context. The default timeout 300,000 ms
		chromeOptions.setPageLoadTimeout(Duration.ofMillis(30000));
		
		//This specifies the time to wait for the implicit element location strategy when locating elements. The default timeout 0 ms
		chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(5));
	
		//Adding chrome extensions with webdriver
		//chromeOptions.addExtensions(new File("/path/to/extension.crx"));
		
		chromeOptions.addArguments("start-maximized");
		//chromeOptions.addArguments("--incognito");
		//chromeOptions.addArguments("--headless"); //invisible mode of execution
		
		//more capabilities at https://chromedriver.chromium.org/capabilities
	//	WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mathu\\eclipse-workspace\\NumpyNinja\\Numpy_Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver.get("https://cosmocode.io/automation-practice");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	
		System.out.println("Current title of the page : " + driver.getTitle());
		System.out.println("Current URL of the page : " + driver.getCurrentUrl());
		driver.navigate().to("https://selenium.dev");
				
		System.out.println("Current title of the page : " + driver.getTitle());
		System.out.println("Current URL of the page : " + driver.getCurrentUrl());
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		
		//driver.close(); //close only current tab
		//driver.quit(); //close all the browser instances/all the tabs
		
		System.out.println("Current page source : " + driver.getPageSource());
		//driver.manage().deleteAllCookies();
		
	
	}

}
