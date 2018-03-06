package Tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Pages.DashboardPageFactory;
import Pages.LoginPage;
import Pages.LoginPageFactory;


public class LoginFactory {
	
	WebDriver driver;
	@Test
	public void Login() {
		String userName="tim@testemail.com";
		String setPassword="trpass";
		
	driver = Utilities.DriverFactory.open("firefox");
	driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	//
	LoginPageFactory loginPage= new LoginPageFactory(driver);
	loginPage.Login(userName, setPassword);
	
	DashboardPageFactory dashboardPage = new DashboardPageFactory(driver);
	//dashboardPage.ElementClicker();		//Call one method or Three separate
	dashboardPage.CancelAcc();
	dashboardPage.UpdateSub();
	dashboardPage.ChangePass();
	
	}
}
