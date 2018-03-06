package SmokeTesting;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {
	WebDriver driver;
	String webURL = "http://sdettraining.com/trguitransactions/NewAccount.aspx";
	
	@Test		// anotacijos leidzia paleisti sita klase 
	public void pageTitleTest() {
		System.out.println("Running the test");
		driver.get(webURL);
		String actualTitle = driver.getTitle();
		String expectedTitle = "SDET Training | Account Management";
		Assert.assertEquals(expectedTitle, actualTitle);		
	}
	
	@Before
	public void setUp() {
		System.out.println("Setting up the test");
		System.out.println("Initializing the driver");
		driver = Utilities.DriverFactory.open("chrome");
	}
	
	@After
	public void tearDown() {
		System.out.println("Closing the test");
		System.out.println("Closing the driver");
		driver.close();
	}
}
