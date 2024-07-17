package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class orangeHRM {

	public WebDriver driver;
	public String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public String uName = "Admin";
	public String pwd = "admin123";
	public String street = "1 avenue";
	public String cityV = "nyc";
	public String num = "2536456525";
	public String stateV = "NY";
	public String zipV = "12345";
	public String e_nameV = "mathu";
	public String d_nameV = "mathi";
	public String r_fName = "mathumathiy";
	public String r_lName = "balak";
	public String created_uName = r_fName;
	public String created_pwd = "a1234567";

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginSaveBtn;
	@FindBy(xpath = "//a[@href='/web/index.php/pim/viewMyDetails']")
	WebElement myInfo;
	@FindBy(xpath = "//*[@href=\"/web/index.php/pim/contactDetails/empNumber/7\"]")
	WebElement contact;
	// contact fields
	@FindBy(xpath = "//*[normalize-space()='Street 1']/parent::div/following-sibling::div/input")
	WebElement stree1;
	@FindBy(xpath = "//*[normalize-space()='City']/parent::div/following-sibling::div/input")
	WebElement city;
	@FindBy(xpath = "//*[normalize-space()='State/Province']/parent::div/following-sibling::div/input")
	WebElement state;
	@FindBy(xpath = "//*[normalize-space()='Zip/Postal Code']/parent::div/following-sibling::div/input")
	WebElement zip;
	@FindBy(xpath = "//*[normalize-space()='Country']/parent::div/following-sibling::div/div/div/div[contains(text(),'-- Select --')]")
	WebElement country;
	@FindBy(xpath = "//*[normalize-space()='Mobile']/parent::div/following-sibling::div/input")
	WebElement mobile;
	// emergency fields
	@FindBy(xpath = "//*[@href=\"/web/index.php/pim/viewEmergencyContacts/empNumber/7\"]")
	WebElement emergency;
	@FindBy(xpath = "//body/div[@id='app']/div/div/div[@class='oxd-layout-context']/div/div/div/div/div/div/button[1]")
	WebElement add;
	@FindBy(xpath = "//*[normalize-space()='Name']/parent::div/following-sibling::div/input")
	WebElement e_name;
	@FindBy(xpath = "//*[normalize-space()='Relationship']/parent::div/following-sibling::div/input")
	WebElement e_relation;
	@FindBy(xpath = "//*[normalize-space()='Mobile']/parent::div/following-sibling::div/input")
	WebElement e_mobile;
	// dependant fields
	@FindBy(xpath = "//*[@href=\"/web/index.php/pim/viewDependents/empNumber/7\"]")
	WebElement dependents;
	// recruitment
	@FindBy(xpath = "//span[normalize-space()='Recruitment']")
	WebElement recruit;
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement add_candidate;
	// candidate fields
	@FindBy(xpath = "//*[@name='firstName']")
	WebElement fName;
	@FindBy(xpath = "//*[@name='lastName']")
	WebElement lName;
	@FindBy(xpath = "//*[normalize-space()='Vacancy']/parent::div/following-sibling::div/div/div/div[normalize-space()='-- Select --']")
	WebElement c_vacancy;
	@FindBy(xpath = "//*[contains(text(),'Email')]/parent::div/following-sibling::div/input")
	WebElement email;
	// shortlist
	@FindBy(xpath = "//button[normalize-space()='Shortlist']")
	WebElement shortlist;
	@FindBy(xpath = "//*[normalize-space()='Notes']/parent::div/following-sibling::div/textarea")
	WebElement s_notes;
	@FindBy(xpath = "//*[@class='orangehrm-recruitment-status']/p")
	WebElement short_status;
	// interviewSchedule
	@FindBy(xpath = "//button[normalize-space()='Schedule Interview']")
	WebElement schedule;
	@FindBy(xpath = "//*[normalize-space()='Interview Title']/parent::div/following-sibling::div/input")
	WebElement interviewTitle;
	@FindBy(xpath = "//*[normalize-space()='Interviewer']/parent::div/following-sibling::div/div/div/input")
	WebElement interviewer;
	@FindBy(xpath = "//input[@placeholder='yyyy-dd-mm']")
	WebElement date;
	// passed interview
	@FindBy(xpath = "//button[normalize-space()='Mark Interview Passed']")
	WebElement markPassed;
	@FindBy(xpath = "//button[normalize-space()='Offer Job']")
	WebElement offerJob;
	@FindBy(xpath = "//button[normalize-space()='Hire']")
	WebElement hire;
	// Admin
	@FindBy(xpath = "//span[normalize-space()='Admin']")
	WebElement admin;
	@FindBy(xpath = "//*[normalize-space()='User Role']/parent::div/following-sibling::div/div/div/div[normalize-space()='-- Select --']")
	WebElement userRole;
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement emp_Name;
	@FindBy(xpath = "//*[normalize-space()='Status']/parent::div/following-sibling::div/div/div/div[normalize-space()='-- Select --']")
	WebElement status;
	@FindBy(xpath = "//*[normalize-space()='Username']/parent::div/following-sibling::div/input")
	WebElement admin_username;
	@FindBy(xpath = "//*[normalize-space()='Password']/parent::div/following-sibling::div/input")
	WebElement admin_password;
	@FindBy(xpath = "//*[normalize-space()='Confirm Password']/parent::div/following-sibling::div/input")
	WebElement admin_confirmPassword;
	// logout
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	WebElement user;
	@FindBy(xpath = "//a[@href=\"/web/index.php/auth/logout\"]")
	WebElement logout;
	// leave
	@FindBy(xpath = "//a[@href=\"/web/index.php/leave/viewLeaveModule\"]")
	WebElement leave;
	@FindBy(xpath = "//a[normalize-space()='Apply']")
	WebElement apply;
	@FindBy(xpath = "//*[normalize-space()='Leave Type']/parent::div/following-sibling::div/div/div/div[contains(text(),'-- Select --')]")
	WebElement leaveType;


//	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	// WebElement toastMessage;

	@BeforeTest
	public void browserSetup() throws Exception {
		driver = new ChromeDriver();
//Launch the application 
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@Test
	public void orangeHRMTest() throws Exception {
		PageFactory.initElements(driver, this);
		username.sendKeys(uName);
		password.sendKeys(pwd);
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Navigate to My info - > Contact Details, enter contact details and press save button 
		myInfo.click();
		contact.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		stree1.click();
		stree1.clear();
		stree1.sendKeys(street);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		city.click();
		city.clear();
		city.sendKeys(cityV);
		state.click();
		state.clear();
		state.sendKeys(stateV);
		zip.click();
		zip.clear();
		zip.sendKeys(zipV);
		mobile.sendKeys(num);
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Navigate to Emergency contacts and add details 
		emergency.click();
		add.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		e_name.click();
		e_name.sendKeys(e_nameV);
		e_relation.click();
		e_relation.sendKeys("mom");
		e_mobile.click();
		e_mobile.sendKeys("2354523545");
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String e_verify = driver.findElement(By.xpath("//div[contains(text(),'" + e_nameV + "')]")).getText();
		Assert.assertEquals(e_verify, e_nameV);
//Navigate to Dependents and add dependents 
		dependents.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		add.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		e_name.click();
		e_name.sendKeys(d_nameV);
		driver.findElement(By.xpath("//div[@class='oxd-select-text-input']")).click();
		driver.findElement(By.xpath("//div//*[contains(text(),'Child')]")).click();
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String d_verify = driver.findElement(By.xpath("//div[contains(text(),'" + d_nameV + "')]")).getText();
		Assert.assertEquals(d_verify, d_nameV);
//Navigate to recruitment menu and add a candidate 
		recruit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		add_candidate.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		fName.sendKeys(r_fName);
		lName.sendKeys(r_lName);
		c_vacancy.click();
		driver.findElement(By.xpath("//*[contains(text(),'Payroll Administrator')]")).click();
		email.sendKeys("mathu@gmail.com");
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String r_verify = driver.findElement(By.xpath(
				"//*[normalize-space()='Name']/parent::div/following-sibling::div/p[@class='oxd-text oxd-text--p']"))
				.getText();
		String r_name = r_fName + " " + r_lName;
		Assert.assertEquals(r_verify, r_name);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//Shortlist the candidate and schedule the interview 
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(shortlist));
		shortlist.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		s_notes.sendKeys("shortlisted candidate");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	//	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
	//	wait2.until(ExpectedConditions.invisibilityOfElementLocated(
	//			By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")));
		String shortlist_message = short_status.getText();
		System.out.println(shortlist_message);
		Assert.assertEquals(shortlist_message, "Status: Shortlisted");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		schedule.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		interviewTitle.sendKeys("QA");
		interviewer.sendKeys("Peter Mac Anderson");
		driver.findElement(By.xpath("//*[normalize-space()='Interviewer']/parent::div/following-sibling::div/div/div/div/span")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		date.sendKeys("2024-07-28");
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String interview_message = short_status.getText();
		System.out.println(interview_message);
		Assert.assertEquals(interview_message, "Status: Interview Scheduled");
//Mark the interview passed and offer job 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		markPassed.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String passed_message = short_status.getText();
		System.out.println(passed_message);
		Assert.assertEquals(passed_message, "Status: Interview Passed");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		offerJob.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String offer_message = short_status.getText();
		System.out.println(offer_message);
		Assert.assertEquals(offer_message, "Status: Job Offered");
//Hire the cand print the candidate history(table) 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		hire.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String hired_message = short_status.getText();
		System.out.println(hired_message);
		Assert.assertEquals(hired_message, "Status: Hired");
		WebElement table = driver.findElement(By.xpath("//*[@class='oxd-table']"));
		 List<WebElement> cells = table.findElements(By.xpath("//*[@class='oxd-table-card']"));
		 for (WebElement cell : cells) {
			 String cellText = cell.getText().trim();
	            String[] lines = cellText.split("\n");
	            if (lines.length == 2) {
	                System.out.print(lines[0] + "\t" + lines[1]);
	            } else {
	             System.out.print(cellText);
	            }
	            System.out.println();  
	        }	
//Navigate back to the Recruitment tab and search for the above candidate and verify the status 
		recruit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(
				"//*[normalize-space()='Vacancy']/parent::div/following-sibling::div/div/div/div[normalize-space()='-- Select --']"))
				.click();
		driver.findElement(By.xpath(
				"//*[normalize-space()='Vacancy']/parent::div/following-sibling::div/div/div/div[normalize-space()='Payroll Administrator']"))
				.click();
		driver.findElement(By.xpath(
				"//*[normalize-space()='Candidate Name']/parent::div/following-sibling::div//input[@placeholder='Type for hints...']"))
				.sendKeys(r_fName);
		driver.findElement(
				By.xpath("//*[normalize-space()='Candidate Name']/parent::div/following-sibling::div/div/div/div/span"))
				.click();
		driver.findElement(By.xpath(
				"//*[normalize-space()='Status']/parent::div/following-sibling::div/div/div/div[normalize-space()='-- Select --']"))
				.click();
		driver.findElement(By.xpath(
				"//*[normalize-space()='Status']/parent::div/following-sibling::div/div/div/div[normalize-space()='Hired']"))
				.click();
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String statusVerify = driver
				.findElement(By.xpath("//*[@class='oxd-table']/div[@class='oxd-table-body']/div/div/div[6]")).getText();
		Assert.assertEquals(statusVerify, "Hired");
//Navigate to the Admin tab and create a user with ESS role for the above employee 
		admin.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		add_candidate.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		userRole.click();
		driver.findElement(By.xpath(
				"//*[normalize-space()='User Role']/parent::div/following-sibling::div/div/div/div[normalize-space()='ESS']"))
				.click();
		emp_Name.sendKeys(r_fName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(
				By.xpath("//*[normalize-space()='Employee Name']/parent::div/following-sibling::div/div/div/div/span"))
				.click();
		status.click();
		driver.findElement(By.xpath(
				"//*[normalize-space()='Status']/parent::div/following-sibling::div/div/div/div[normalize-space()='Enabled']"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		admin_username.sendKeys(created_uName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		admin_password.sendKeys(created_pwd);
		admin_confirmPassword.sendKeys(created_pwd);
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")); // just to verify
//Precondition for applying leave
		leave.click();
		driver.findElement(By.xpath("//header[@class='oxd-topbar']//li[3]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Add Entitlements']")).click();
		driver.findElement(By.xpath("//*[normalize-space()='Employee Name']/parent::div/following-sibling::div/div/div/input")).sendKeys(r_fName);
		driver.findElement(By.xpath("//*[normalize-space()='Employee Name']/parent::div/following-sibling::div/div/div/div/span")).click();
		driver.findElement(By.xpath("//*[normalize-space()='Leave Type']/parent::div/following-sibling::div/div/div[normalize-space()='-- Select --']")).click();
		driver.findElement(By.xpath("//*[normalize-space()='Leave Type']/parent::div/following-sibling::div/div/div/following::span[normalize-space()='CAN - Vacation']")).click();
		driver.findElement(By.xpath("//*[normalize-space()='Entitlement']/parent::div/following-sibling::div/input")).sendKeys("20");
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//Logout from the application and login with the above created username & password 
		user.click();
		logout.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		username.sendKeys(created_uName);
		password.sendKeys(created_pwd);
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String createdName_verify = driver.findElement(By.xpath("//*[@class='oxd-userdropdown-name']")).getText();
		Assert.assertEquals(createdName_verify, r_name);
 //Navigate to leave menu and apply personal leave, Logout from the application 
		leave.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		apply.click(); 
		leaveType.click(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//*[normalize-space()='Leave Type']/parent::div/following-sibling::div/div/div/div[normalize-space()='CAN - Vacation']")).click(); 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement fromDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[normalize-space()='From Date']/parent::div/following-sibling::div/div/div/input")));
	        WebElement toDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[normalize-space()='To Date']/parent::div/following-sibling::div/div/div/input")));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value = '2024-07-23'; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('blur'));", fromDate);
	        js.executeScript("arguments[0].value = '2024-07-26'; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('blur'));", toDate);
	        WebElement Save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))); 
	        Save.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		user.click();
		logout.click();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//Login with the Admin user again and navigate to Leave menu 
		username.sendKeys(uName);
		password.sendKeys(pwd);
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		leave.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Approve the above applied leave under leave list and logout   	
		driver.findElement(By.xpath("//*[normalize-space()='Employee Name']/parent::div/following-sibling::div/div/div/input")).sendKeys(r_fName);
		driver.findElement(By.xpath("//*[normalize-space()='Employee Name']/parent::div/following-sibling::div/div/div/div/span")).click();
		loginSaveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.xpath("//button[normalize-space()='Approve']")).click();
		user.click();
		logout.click();
		
		
		
	}

}
