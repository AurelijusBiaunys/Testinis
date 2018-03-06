package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

	WebDriver driver;
	//finding elements
	@FindBy(id="MainContent_txtUserName")	//defines what's coming next
	WebElement userNameBox;
	
	@FindBy(id="MainContent_txtPassword")
	WebElement userPasswordBox;
	
	@FindBy(id="MainContent_btnLogin")
	WebElement clickSubmitButton;
	//steps with elements
	public void setUserName(String userName) {
		userNameBox.sendKeys(userName);
	}
	
	public void setPassword(String userPassword) {
		userPasswordBox.sendKeys(userPassword);
	}
	
	public void clickSubmit() {
		clickSubmitButton.click();
	}
	//actions with elements
	public void Login(String userNameBox, String userPasswordBox) {
		setUserName(userNameBox);
		setPassword(userPasswordBox);
		clickSubmit();
	}
	
	public LoginPageFactory(WebDriver driver) {		//constructor initializes the state of the driver
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
