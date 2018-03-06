package Tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



@RunWith(value = Parameterized.class)
public class NewAccountForDataDrivenTest {
	String name, email, phone, gender, password, country;
	boolean weekly, monthly, occasional;
	WebDriver driver;
	
	//our test method
	@Test
	public void newAccountTest() {
		System.out.println("Records: "+name+" "+email+" "+phone+" "+gender+" "+password+" "+country+" "+ weekly+ " "+ monthly+ " "+ occasional);
	
	
	//---------------------------------------------------------
	// define Web elements
			WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
			WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
			WebElement phoneElement = driver.findElement(By.name("ctl00$MainContent$txtHomePhone"));
			//WebElement passwordElement = driver.findElement(By.name("ctl00$MainContent$txtPassword"));
			WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword'][type='password']"));
			WebElement passVerElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
																																					//driver.findElement(By.linkText("Create Account")).click(); //linkText is for links
			// fill the form 
			nameElement.sendKeys(name);				//name
			emailElement.sendKeys(email);   		//email
			phoneElement.sendKeys(phone);   	//phone
			passwordElement.sendKeys(password);		//password
			passVerElement.sendKeys(password); 		//password verification
		
			
			// Radio button
			if (gender.equals("Male")){
				driver.findElement(By.name("ctl00$MainContent$Gender")).click();;	
			}
			else {
				driver.findElement(By.id("MainContent_Female")).click();	
			}
				
			// Drop down menu of a country	
			new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText(country);
			
			// Check boxes for email
			if (weekly) {
				if (!driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).isSelected())
				{	driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();		}
			}
			else {
				if (driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).isSelected())
				{	driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();		}
			}
			
			if (monthly) {
				if (!driver.findElement(By.id("MainContent_checkMonthlyEmail")).isSelected())
				{	driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();		}
			}	
			else {
				if(driver.findElement(By.id("MainContent_checkMonthlyEmail")).isSelected())
				{	driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();		}
			}
			
			if (occasional) {
				if (!driver.findElement(By.id("MainContent_checkUpdates")).isSelected())
				{	driver.findElement(By.id("MainContent_checkUpdates")).click();		}
			}
			else {
				if(driver.findElement(By.id("MainContent_checkUpdates")).isSelected())
				{	driver.findElement(By.id("MainContent_checkUpdates")).click();		}
			}
	//---------------------------------------------------------
	}
	@Before
	public void setUp() {
		driver = Utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.cssSelector("a[href='NewAccount.aspx']")).click();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	//method design to pass parameters into class via constructor
	@Parameters
	public static List<String[]> getData(){
		return Utilities.CSV.get("C:\\Users\\User\\Desktop\\Mokslai\\WEB\\Selenium\\Software\\UserAccounts.csv");
	}
	
	//Constructor that passes parameters to test method
	public NewAccountForDataDrivenTest(String name, String email, String phone, String gender, String password, String country,	String weekly, String monthly, String occasional) 
	{	
	this.name = name;
	this.email= email;
	this.phone = phone;
	this.gender = gender;
	this.password = password;
	this.country = country;
	
	if (weekly.equals("TRUE")){
		this.weekly = true;
	} else {this.weekly = false;}
	
	if(monthly.equals("TRUE")) {
		this.monthly= true;
	}else {
		this.monthly=false;	}
	
		if(occasional.equals("TRUE")) {
			this.occasional=true;}
			else {this.occasional=false;}
	}
}
