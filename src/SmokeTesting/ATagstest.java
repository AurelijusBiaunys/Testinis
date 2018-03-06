package SmokeTesting;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ATagstest {
WebDriver driver;
	
	@Test
	public void LoginElementPresentTest(){
		boolean createAccountPresent = false;
		System.out.println("Running test");
		String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";	//nueinama i norima puslapi
		driver.get(webURL);
		
		//test the presents of a tags
		List <WebElement> aElements = driver.findElements(By.tagName("a"));
		int numberOfAElements = aElements.size();
		System.out.println("there are " + numberOfAElements + " <a> tag elements on the page");
		for (WebElement aElement : aElements) {
			System.out.println(aElement.getText());
			if (aElement.getText().equals("CREATE ACCOUNT")) {
				createAccountPresent = true; 
				break; 		//if you want to exit the loop
			}
		}
		Assert.assertTrue(createAccountPresent);
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.print("Starting test");
		driver = Utilities.DriverFactory.open("chrome");	//atidaryti chrome is kito failo
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing test");
		driver.close();
	}
}
