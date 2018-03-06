package Demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {

		String name = "Aurelijus";
		String email = "pastas@mail.lt";
		String password = "passWordas";
		String country = "Brazil";
		String phoneNumber = "370123456";
		String browserType = "Firefox";
		String gender = "Female";
		boolean weekly = true;
		boolean monthly = true;
		boolean occassional= true;
		
		//Web driver definition
		WebDriver driver;
		driver = Utilities.DriverFactory.open(browserType);		

		// navigate to account management page, click on 'create account'  
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");																									
		driver.findElement(By.cssSelector("a[href='NewAccount.aspx'][class='btn btn-default']")).click();
				
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
		phoneElement.sendKeys(phoneNumber);   	//phone
		passwordElement.sendKeys(password);		//password
		passVerElement.sendKeys(password); 		//password verification
	
		
		// Radio button
		if (gender=="Male"){
			driver.findElement(By.name("ctl00$MainContent$Gender")).click();;	
		}
		else {
			driver.findElement(By.id("MainContent_Female")).click();	
		}
			
		// Drop down menu	
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Israel");
		
		// Check boxes
		if (weekly) {
			if (!driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).isSelected());
			{
				driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
			}
		}
			else { if (driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).isSelected());
			{
				driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
			}
		}	
		if (monthly) {
			if (!driver.findElement(By.id("MainContent_checkMonthlyEmail")).isSelected());
			{
				driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
			}
		}		
		if (occassional) {
			if (!driver.findElement(By.id("MainContent_checkUpdates")).isSelected());
			{
				driver.findElement(By.id("MainContent_checkUpdates")).click();
			}
		}
			
		// submit button
		driver.findElement(By.id("MainContent_btnSubmit")).click();
	
		// get confirmation
		String confirmation = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if (confirmation.equals(expected)) {
		System.out.println("Messege " + confirmation);
		}
		else
		{
			System.out.println("test failed");
		}
			// close application
		driver.close();
	}

}
