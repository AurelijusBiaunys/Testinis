package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public void setUserName(String userName) {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(userName);
	}
	
	public void setPassword(String userPassword) {
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(userPassword);
	}
	
	public void clickSubmit() {
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	public LoginPage(WebDriver driver) {		//constructor initializes the state of the driver
		this.driver = driver;
	}
	

}
