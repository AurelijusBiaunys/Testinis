package Demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		//1. create web driver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Desktop\\Mokslai\\WEB\\Selenium\\Software\\geckodriver.exe ");
		WebDriver driver = new FirefoxDriver();
		
		//2. navigate to account management page
		//   click on 'create account'
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("Create Account")).click(); //linkText is for links
		
		//3. fill the form
		//locate elements
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("smily");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("rundelis@gmail.lt");
		driver.findElement(By.name("ctl00$MainContent$txtHomePhone")).sendKeys("987654321");
		
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword'][type='password']")).sendKeys("password");
		driver.findElement(By.cssSelector("input[class='form-control'][type='password'][id='MainContent_txtVerifyPassword']")).sendKeys("pass");
		
		//interact with elements
		driver.findElement(By.id("MainContent_Female")).click();
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Algeria");
		driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
		driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$checkUpdates']")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		//4. get confirmation
		//String conf = driver.findElement(By.cssSelector("span[class='heading-title']")).getText();	//neveikia
		String confirmation = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("Messege " + confirmation);
		
		//5. close application
		driver.close();
	}

}
