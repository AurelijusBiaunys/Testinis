package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageFactory {
	
	WebDriver driver;
	
	@FindBy (linkText="Change password")
	WebElement ChangePassword;
	
	@FindBy (linkText="Updated subscriptions")
	WebElement UpdateSubscriptions;
	
	@FindBy (linkText="Cancel account")
	WebElement CancelAccount;
	
	public void ChangePass(){
		ChangePassword.click();
	}
	public void UpdateSub() {
		UpdateSubscriptions.click();
	}	
	public void CancelAcc() {
		CancelAccount.click();
	}
	
	public void ElementClicker() {
		ChangePass();
		UpdateSub();
		CancelAcc();		
	}

	public DashboardPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
}
