package StepImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BDDLoginTest {

	WebDriver driver;
	
	@Given("^user is on the login page$")
	public void Given_User_is_on_the_log_in_page() {
		System.out.println("Print: User is on the log in page");
		//open driver
		driver= Utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@When("^user enters correct username and correct password$")
	public void When_User_enters_correct_username_and_correct_password() {
		System.out.println("Print: User enters correct username and correct password");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("Aurelijus@mail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("Password");
		driver.findElement(By.cssSelector("input[class = 'btn btn-primary']")).click();
	}
	
	 @When ("^user enters email (.*)$")
	 public void user_enters_username(String username) {
		 System.out.println("Testing: " + username);
			driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	 }
	 
	 @And ("^user enters password (.*)$")
	 public void user_enters_password(String password) {
		 System.out.println("Testing: " + password);
			driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	 }
	
	 @And ("^user clicks login$")
	 public void user_clicks_login() {
		 System.out.println("Clicking login button");
			driver.findElement(By.cssSelector("input[class = 'btn btn-primary']")).click();
	 }
	 
	@Then("^user gets confirmation$")
	public void user_gets_confirmation() {
		System.out.println("Print: User gets confirmation");
		String Conf = driver.findElement(By.cssSelector("small[style='text-transorm:uppercase']")).getText();
		System.out.println(Conf);
		//Assert.assertTrue(driver.findElement(By.id("conf_message")).getText().contains("successfully"));	
	}
	
	@After
	public void TearDown() {
		driver.quit();
	}
}
