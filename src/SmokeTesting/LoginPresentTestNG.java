package SmokeTesting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.openqa.selenium.WebElement;

public class LoginPresentTestNG {
	WebDriver driver;
	
	@Test
	public void LoginElementPresentTest(){
		System.out.println("Running test");
		String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver.get(webURL);
		
		boolean LoginEmail = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean LoginPassword = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
	
		Assert.assertTrue(LoginEmail);
		Assert.assertTrue(LoginPassword);
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.print("Starting test");
		driver = Utilities.DriverFactory.open("chrome");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing test");
		driver.close();
	}
	
}
