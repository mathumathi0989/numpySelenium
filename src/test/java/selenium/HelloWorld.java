package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HelloWorld {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mathu\\eclipse-workspace\\NumpyNinja\\Numpy_Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\mathu\\eclipse-workspace\\NumpyNinja\\Numpy_Selenium\\src\\test\\resources\\drivers\\msedgedriver.exe");
		
	//	WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		driver.get("https://amazon.com");
		
		
		
	}
	
	
	
}
