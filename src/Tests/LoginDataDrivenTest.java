package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataDrivenTest {
	WebDriver driver;
	@Test(dataProvider = "getData")
	public void loginTest(String name, String email, String password) {
		//System.out.println("New Record"+ name +" "+ email +" "+password);
		//1. define the web driver //copied from Login.java
				//System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Mokslai\\WEB\\Selenium\\Software\\chromedriver.exe");
				//WebDriver driver = new ChromeDriver();
				//2. open the browser and navigate to the web page
				//driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
				//Find elements: locate element, determine the action, pass parameters
				//3. enter email address
				driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
				//4. enter password
				driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
				//5. click login
				driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
				//6. get confirmation
				String messege = driver.findElement(By.id("conf_message")).getText();
				System.out.println(messege);
				//7. close the browser
				//driver.close();
	}
	
	@BeforeMethod
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Mokslai\\WEB\\Selenium\\Software\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		driver = Utilities.DriverFactory.open("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public String[][] getData(){
		return Utilities.Excel.get("C:\\Users\\User\\Desktop\\Mokslai\\WEB\\Selenium\\Software\\UserLogin.xls");
	}
	
}
