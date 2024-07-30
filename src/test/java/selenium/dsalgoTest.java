package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dsalgoTest {

	
	private WebDriver driver;
    private dsalgoPage DsalgoPage;
    private String url = "http://dsportalapp.herokuapp.com/";
    private String alertMessage ;
    
    @BeforeTest
    public void setUp() {
    //    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        DsalgoPage = new dsalgoPage(driver);
    }

    @Test
    public void testDSALGO() {
    	
    	//WebPage
    	DsalgoPage.clickGetStarted();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	
    	/*
    	//register
    	DsalgoPage.clickregister();
    	DsalgoPage.enterUserName("mathu");
    	DsalgoPage.enterPassword("mathumathi");
    	DsalgoPage.enterConfirmPassword("mathumathi");
    	DsalgoPage.clickregisterButton();
    	DsalgoPage.getAlertMessage();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	*/
    	/*
    	//Signout
    	DsalgoPage.clickSignOut();
    	DsalgoPage.getAlertMessage();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	*/
    	//Signin
    	DsalgoPage.clickSignIn();
    	DsalgoPage.enterUserName("mathu");
    	DsalgoPage.enterPasswordSignIn("mathumathi");
    	DsalgoPage.clickLoginSignInPage();
    	alertMessage = DsalgoPage.getAlertMessage();
    	Assert.assertEquals(alertMessage, "You are logged in");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	//DataStructures -Intro
    	System.out.println("---------------------DataStructures Introduction-------------------------------------------");
    	DsalgoPage.clickDataStrucIntro();
    	DsalgoPage.topicsCovered();
    	System.out.println("---------------------------------------------------------------------------");
    	//Array
    	System.out.println("-----------------------Array-----------------------------------------");
    	DsalgoPage.clickNumpyNinja();
    	DsalgoPage.clickGetStarted();
    	DsalgoPage.clickArray();
    	DsalgoPage.topicsCovered();
    	System.out.println("---------------------------------------------------------------------------");
    	//LinkedList
    	System.out.println("------------------------LinkedList----------------------------------------");
    	DsalgoPage.clickNumpyNinja();
    	DsalgoPage.clickGetStarted();
    	DsalgoPage.clickLinkedList();
    	DsalgoPage.topicsCovered();
    	System.out.println("---------------------------------------------------------------------------");
    	//Stack
    	System.out.println("--------------------------Stack--------------------------------------");
    	DsalgoPage.clickNumpyNinja();
    	DsalgoPage.clickGetStarted();
    	DsalgoPage.clickStack();
    	DsalgoPage.topicsCovered();
    	System.out.println("---------------------------------------------------------------------------");
    	//Queue
    	System.out.println("-----------------------------Queue-----------------------------------");
    	DsalgoPage.clickNumpyNinja();
    	DsalgoPage.clickGetStarted();
    	DsalgoPage.clickQueue();
    	DsalgoPage.topicsCovered();
    	System.out.println("---------------------------------------------------------------------------");
    	//Tree
    	System.out.println("---------------------------Tree-------------------------------------");
    	DsalgoPage.clickNumpyNinja();
    	DsalgoPage.clickGetStarted();
    	DsalgoPage.clickTree();
    	DsalgoPage.topicsCovered();
    	System.out.println("---------------------------------------------------------------------------");
    	//Graph
    	System.out.println("---------------------------Graph-------------------------------------");
    	DsalgoPage.clickNumpyNinja();
    	DsalgoPage.clickGetStarted();
    	DsalgoPage.clickGraph();
    	DsalgoPage.topicsCovered();
    	System.out.println("---------------------------------------------------------------------------");
    	
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    
}
