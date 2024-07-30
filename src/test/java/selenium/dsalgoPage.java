package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dsalgoPage {
	
	 private WebDriver driver;
	
	 
	  public dsalgoPage(WebDriver driver) {
	        this.driver = driver;
	    }

	  
	  
	 //GetStarted page
	 private By getStartedButton = By.xpath("//button[@class='btn']");
	 
	 public void clickGetStarted() {
		 driver.findElement(getStartedButton).click();
	 }
	 
	 //home page
	 private By numpyNinja = By.xpath("//a[@class='navbar-brand']");
	 private By dsDropdown = By.xpath("//a[@class='nav-link dropdown-toggle']");
	 private By dsDropdownClick = By.xpath("//div[@class='dropdown-menu show']");
	 private By dsDropdownList = By.xpath("//div[@class='dropdown-menu show']/a");
	 private By alert = By.xpath("//div[@role='alert']");
	
	 
	 private By dataStrucIntro = By.xpath("//a[@href='data-structures-introduction']");
	 private By array = By.xpath("//a[@href='array']");
	 private By linkedList = By.xpath("//a[@href='linked-list']");
	 private By stack = By.xpath("//a[@href='stack']");
	 private By queue = By.xpath("//a[@href='queue']");
	 private By tree = By.xpath("//a[@href='tree']");
	 private By graph = By.xpath("//a[@href='graph']");
	 
	 public void clickNumpyNinja() {
		 driver.findElement(numpyNinja).click();
	 }
	 
	
	 public void clickDataStrucIntro() {
		 driver.findElement(dataStrucIntro).click();
	 }
	
	 public void clickArray() {
		 driver.findElement(array).click();
	 }
	 public void clickLinkedList() {
		 driver.findElement(linkedList).click();
	 }
	 public void clickStack() {
		 driver.findElement(stack).click();
	 }
	 public void clickQueue() {
		 driver.findElement(queue).click();
	 }
	 public void clickTree() {
		 driver.findElement(tree).click();
	 }
	 public void clickGraph() {
		 driver.findElement(graph).click();
	 }
	 public String getAlertMessage() {
		 return driver.findElement(alert).getText();
		  
	 }
	 
	 //Register
	 private By register = By.xpath("//a[normalize-space()='Register']");
	 private By userName = By.xpath("//input[@id='id_username']");
	 private By password = By.xpath("//input[@id='id_password1']");
	 private By confirmPassword = By.xpath("//input[@id='id_password2']");
	 private By registerButton = By.xpath("//input[@value='Register']");
	 private By loginLink = By.xpath("//a[normalize-space()='Login']");
	 
	 public void clickregister() {
		 driver.findElement(register).click();
	 }
	 public void enterUserName(String uName) {
		 driver.findElement(userName).sendKeys(uName);
	 }
	 public void enterPassword(String pwd) {
		 driver.findElement(password).sendKeys(pwd);
	 }
	 public void enterConfirmPassword(String confirmPwd) {
		 driver.findElement(confirmPassword).sendKeys(confirmPwd);
	 }
	 public void clickregisterButton() {
		 driver.findElement(registerButton).click();
	 }
	 public void clickLogin() {
		 driver.findElement(loginLink).click();
	 }
	 //Signin
	 private By signIn = By.xpath("//a[normalize-space()='Sign in']");
	 private By passwordLogin = By.xpath("//input[@id='id_password']");
	 private By loginButton = By.xpath("//input[@value='Login']");
	 private By registerLink = By.xpath("//a[normalize-space()='Register!']");
	 
	 public void clickSignIn() {
		 driver.findElement(signIn).click();
	 }
	 public void enterPasswordSignIn(String pwd) {
		 driver.findElement(passwordLogin).sendKeys(pwd);
	 }
	 public void clickLoginSignInPage() {
		 driver.findElement(loginButton).click();
	 }
	 public void clickRegisterLoginPage() {
		 driver.findElement(registerLink).click();
	 }
	 
	 //SignOut
	 private By signOut = By.xpath("//a[normalize-space()='Sign out']");
	 
	 public void clickSignOut() {
		 driver.findElement(signOut).click();
	 }
	 
	
	 
	 //Topics Covered
	 public void topicsCovered() {
	        List<WebElement> links = driver.findElements(By.xpath("//a[@class='list-group-item']"));
	        for (WebElement link : links) {
	            String url = link.getAttribute("href");
	            System.out.println("Clicking on: " + url);
	            link.click();
	            System.out.println("Title of the page: " + driver.getTitle());
	            clickTryHere();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	            editTryHere("print\"hello\"");
	            clickRun();
	            String codeOutput = driver.findElement(By.xpath("//pre[@id='output']")).getText();
	            System.out.println(codeOutput);
	            driver.navigate().back();
	            driver.navigate().back();
	            links = driver.findElements(By.xpath("//a[@class='list-group-item']"));
	        }
	 }
	 
	 //Try Here
	 private By tryhereButton = By.xpath("//a[@class='btn btn-info']");
	 private By runButton = By.xpath("//button[@type='button']");
	 
	 public void clickTryHere() {
		 driver.findElement(tryhereButton).click();
	 }
	 
	 public void editTryHere(String code) {
	        String script = "var editor = document.querySelector('.CodeMirror').CodeMirror;" +
	                        "editor.setValue(arguments[0]);";
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript(script, code);
	 }
	 
	 public void clickRun() {
		 driver.findElement(runButton).click();
	 }
	 

	 //Practice Questions
	 
	 
	

	  
	
	 
	 
	  

	
}
