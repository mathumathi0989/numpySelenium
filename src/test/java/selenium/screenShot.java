package selenium;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenShot {
	static WebDriver driver;
	public static void takeSS(String stepName) throws Exception {

		driver = new ChromeDriver();
		driver.get("https://selenium.dev");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		TakesScreenshot ss = (TakesScreenshot) driver;
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		String TCName = "TC_001";
		String dir = System.getProperty("user.dir");
		String time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		// Timestamp time = new Timestamp(System.currentTimeMillis());
		// System.out.println(time);
		String path = dir + "\\src\\test\\resources\\screenshots\\" + TCName + "\\screenshot_" + stepName + "_" + time
				+ ".png";

		// System.out.println("Saving screenshot to: " + path);
		// System.out.println(path);
		
		File destFile = new File(path);
		FileUtils.copyFile(srcFile, destFile);
		
		/*
		 * if (destFile.exists()) { System.out.println("Screenshot saved successfully: "
		 * + destFile.getAbsolutePath()); } else {
		 * System.out.println("Failed to save screenshot."); }
		 */
		driver.quit();

	}

	public static void alertSS(String stepName) throws Exception {
		driver = new ChromeDriver();
		driver.get("");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		TakesScreenshot ss = (TakesScreenshot) driver;
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		String TCName = "TC_001";
		String dir = System.getProperty("user.dir");
		String time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		// Timestamp time = new Timestamp(System.currentTimeMillis());
		// System.out.println(time);
		String path = dir + "\\src\\test\\resources\\screenshots\\" + TCName + "\\screenshot_" + stepName + "_" + time
				+ ".png";

		// System.out.println("Saving screenshot to: " + path);
		// System.out.println(path);
		
		File destFile = new File(path);
		FileUtils.copyFile(srcFile, destFile);
		
		/*
		 * if (destFile.exists()) { System.out.println("Screenshot saved successfully: "
		 * + destFile.getAbsolutePath()); } else {
		 * System.out.println("Failed to save screenshot."); }
		 */
		driver.quit();
	}
	public static void main(String[] args) throws Exception {
		takeSS("SeleniumHomePage");
		alertSS("alertPage");
	}

}
