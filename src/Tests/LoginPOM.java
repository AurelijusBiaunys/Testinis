package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Pages.DashboardPage;
import Pages.LoginPage;


public class LoginPOM {
	@Test
	public void loginTestPOM() {
	//initialize the driver
	WebDriver driver = Utilities.DriverFactory.open("firefox");
	driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	
	//enter login information
	LoginPage loginPage = new LoginPage(driver);
	loginPage.setPassword("passWordas");
	loginPage.setUserName("pastas@mail.lt");
	loginPage.clickSubmit();
	//get confirmation
	DashboardPage dashboardPage = new DashboardPage(driver);
	dashboardPage.cancelAccount();
	dashboardPage.changePassword();
	dashboardPage.updateSubscription();
	
	String confirm = dashboardPage.confirmationMessage();
	System.out.println(confirm);
	Assert.assertTrue(confirm.contains("success"));
	Assert.assertTrue(confirm, true);
	String title = dashboardPage.title();
	Assert.assertTrue(title.contains("Account"));
	System.out.println(title);
	
	//close the driver
	//driver.quit();
	}
}
