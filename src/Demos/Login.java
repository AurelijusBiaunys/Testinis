package Demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		//1. define the web driver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Mokslai\\WEB\\Selenium\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//2. open the browser and navigate to the web page
		//   http://sdettraining.com/trguitransactions/AccountManagement.aspx
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//Find elements: locate element, determine the action, pass parameters
		//3. enter email address
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("aurelijus@gmail.com");
		//4. enter password
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("test");
		//5. click login
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		//6. get confirmation
		String messege = driver.findElement(By.id("conf_message")).getText();
		System.out.println(messege);
		
		String pageTitle = driver.getTitle();
		if (pageTitle == "SDET Training | Account Management");
		{
			System.out.println("Page title passed");
		}
		
		//7. close the browser
		driver.close();
	}

}
